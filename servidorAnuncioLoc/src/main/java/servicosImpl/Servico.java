package servicosImpl;

import dominio.Anuncio;
import dominio.PerfilChave;
import dominio.RestricaoChave;
import dominio.Utilizador;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.ejb.Stateless;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import persistencia.AcessoDados;

@WebService(serviceName = "Servico")
@Stateless
public class Servico {

    @EJB
    private AcessoDados acess; // NÃO usar new, deixa o contêiner injetar!

    @WebMethod(operationName = "registar_utilizador")
    public String hello(@WebParam(name = "nome") String nome, @WebParam(name = "email") String email, @WebParam(name = "senha") String senha) {
        return acess.registar_utilizador(new Utilizador(null, nome, email, senha, "01", 10));
    }

    @WebMethod(operationName = "postar_mensagem")
    public String postar_mensagem(@WebParam(name = "utilizador") int id_utilizador, @WebParam(name = "restricao") int restricao, @WebParam(name = "mensagem") String sms, @WebParam(name = "titulo") String titulo, @WebParam(name = "local") int local, @WebParam(name = "data") String data, @WebParam(name = "hora") String hora, @WebParam(name = "data_fim") String data_fim, @WebParam(name = "hora_fim") String hora_fim, @WebParam(name = "modo") String modo) {
        //Anuncio(Integer id, Date data, Date hora, Date dataFim, Date horaFim, String titulo, String mensagem, int idLocal)
        //Anuncio(Integer id, Date data, Date hora, Date dataFim, Date horaFim, String titulo, String mensagem, String modo, int idLocal, Date time)
        return acess.postar_mensagem(new Anuncio(null, data, hora, data_fim, hora_fim, titulo, sms, modo, local, new java.util.Date()), restricao, id_utilizador);
    }

    @WebMethod(operationName = "criar_perfil")
    public String criar_perfil(@WebParam(name = "chave") String chave, @WebParam(name = "valor") String valor, @WebParam(name = "id_utilizador") int id_utilizador) {
        return acess.criar_chave(new PerfilChave(null, chave, valor), id_utilizador);
    }

    @WebMethod(operationName = "criar_restricao")
    public String criar_restricao(@WebParam(name = "id_restricao") int id_restricao, @WebParam(name = "id_chave") int id_chave) {
        return acess.criar_restricao(id_restricao, id_chave);
    }

    @WebMethod(operationName = "sms_descentralizada")
    public List<Anuncio> sms_descentralizada(@WebParam(name = "id_utilizador") int id_utilizador) {
        return acess.descentralizada(id_utilizador);
    }
}
