package security;

import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.SignedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TokenFilter implements Filter {

    private static final Logger logger = Logger.getLogger(TokenFilter.class.getName());
    private RSAPublicKey publicKey;
    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (attempts < MAX_ATTEMPTS) {
            try {
                String jwksUrl = "http://localhost:8180/realms/g10/protocol/openid-connect/certs";
                logger.log(Level.INFO, "Tentando carregar chaves do Keycloak de: {0}", jwksUrl);

                DefaultResourceRetriever retriever = new DefaultResourceRetriever(CONNECTION_TIMEOUT, READ_TIMEOUT);
                URL url = new URL(jwksUrl);
                com.nimbusds.jose.util.Resource resource = retriever.retrieveResource(url);

                JWKSet jwkSet = JWKSet.parse(resource.getContent());
                JWK jwk = jwkSet.getKeys().get(0);
                publicKey = jwk.toRSAKey().toRSAPublicKey();

                logger.info("Chave pública carregada com sucesso");
                return;

            } catch (Exception e) {
                attempts++;
                logger.log(Level.SEVERE, "Tentativa {0} falhou: {1}", new Object[]{attempts, e.getMessage()});

                if (attempts >= MAX_ATTEMPTS) {
                    throw new ServletException("Falha ao carregar chave pública após " + MAX_ATTEMPTS + " tentativas", e);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new ServletException("Thread interrompida durante tentativa de reconexão", ie);
                }
            }
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Cabeçalho Authorization ausente ou malformado");
            return;
        }

        String token = authHeader.substring(7);

        try {
            SignedJWT signedJWT = SignedJWT.parse(token);

            if (!signedJWT.verify(new RSASSAVerifier(publicKey))) {
                logger.warning("Assinatura JWT inválida");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Assinatura inválida");
                return;
            }

            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            if (!claims.getIssuer().equals("http://localhost:8180/realms/Ismae")) {
                logger.warning("Issuer inválido: " + claims.getIssuer());
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido (issuer incorreto)");
                return;
            }

            if (claims.getExpirationTime() == null || claims.getExpirationTime().before(new Date())) {
                logger.warning("Token expirado");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token expirado");
                return;
            }

            chain.doFilter(req, res);

        } catch (ParseException e) {
            logger.log(Level.WARNING, "Token malformado", e);
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Token malformado");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao validar token", e);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Erro ao validar token");
        }
    }

    @Override
    public void destroy() {
        logger.info("TokenFilter sendo destruído");
    }
}
