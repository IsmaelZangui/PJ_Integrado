
package ao.uan.ponte.soap;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ao.uan.ponte.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Anuncio_QNAME = new QName("http://servicosImpl/", "anuncio");
    private final static QName _CriarPerfil_QNAME = new QName("http://servicosImpl/", "criar_perfil");
    private final static QName _CriarPerfilResponse_QNAME = new QName("http://servicosImpl/", "criar_perfilResponse");
    private final static QName _CriarRestricao_QNAME = new QName("http://servicosImpl/", "criar_restricao");
    private final static QName _CriarRestricaoResponse_QNAME = new QName("http://servicosImpl/", "criar_restricaoResponse");
    private final static QName _PostarMensagem_QNAME = new QName("http://servicosImpl/", "postar_mensagem");
    private final static QName _PostarMensagemResponse_QNAME = new QName("http://servicosImpl/", "postar_mensagemResponse");
    private final static QName _RegistarUtilizador_QNAME = new QName("http://servicosImpl/", "registar_utilizador");
    private final static QName _RegistarUtilizadorResponse_QNAME = new QName("http://servicosImpl/", "registar_utilizadorResponse");
    private final static QName _Restricao_QNAME = new QName("http://servicosImpl/", "restricao");
    private final static QName _SmsDescentralizada_QNAME = new QName("http://servicosImpl/", "sms_descentralizada");
    private final static QName _SmsDescentralizadaResponse_QNAME = new QName("http://servicosImpl/", "sms_descentralizadaResponse");
    private final static QName _Utilizador_QNAME = new QName("http://servicosImpl/", "utilizador");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ao.uan.ponte.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Anuncio }
     * 
     */
    public Anuncio createAnuncio() {
        return new Anuncio();
    }

    /**
     * Create an instance of {@link CriarPerfil }
     * 
     */
    public CriarPerfil createCriarPerfil() {
        return new CriarPerfil();
    }

    /**
     * Create an instance of {@link CriarPerfilResponse }
     * 
     */
    public CriarPerfilResponse createCriarPerfilResponse() {
        return new CriarPerfilResponse();
    }

    /**
     * Create an instance of {@link CriarRestricao }
     * 
     */
    public CriarRestricao createCriarRestricao() {
        return new CriarRestricao();
    }

    /**
     * Create an instance of {@link CriarRestricaoResponse }
     * 
     */
    public CriarRestricaoResponse createCriarRestricaoResponse() {
        return new CriarRestricaoResponse();
    }

    /**
     * Create an instance of {@link PostarMensagem }
     * 
     */
    public PostarMensagem createPostarMensagem() {
        return new PostarMensagem();
    }

    /**
     * Create an instance of {@link PostarMensagemResponse }
     * 
     */
    public PostarMensagemResponse createPostarMensagemResponse() {
        return new PostarMensagemResponse();
    }

    /**
     * Create an instance of {@link RegistarUtilizador }
     * 
     */
    public RegistarUtilizador createRegistarUtilizador() {
        return new RegistarUtilizador();
    }

    /**
     * Create an instance of {@link RegistarUtilizadorResponse }
     * 
     */
    public RegistarUtilizadorResponse createRegistarUtilizadorResponse() {
        return new RegistarUtilizadorResponse();
    }

    /**
     * Create an instance of {@link Restricao }
     * 
     */
    public Restricao createRestricao() {
        return new Restricao();
    }

    /**
     * Create an instance of {@link SmsDescentralizada }
     * 
     */
    public SmsDescentralizada createSmsDescentralizada() {
        return new SmsDescentralizada();
    }

    /**
     * Create an instance of {@link SmsDescentralizadaResponse }
     * 
     */
    public SmsDescentralizadaResponse createSmsDescentralizadaResponse() {
        return new SmsDescentralizadaResponse();
    }

    /**
     * Create an instance of {@link Utilizador }
     * 
     */
    public Utilizador createUtilizador() {
        return new Utilizador();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Anuncio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Anuncio }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "anuncio")
    public JAXBElement<Anuncio> createAnuncio(Anuncio value) {
        return new JAXBElement<Anuncio>(_Anuncio_QNAME, Anuncio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarPerfil }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarPerfil }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "criar_perfil")
    public JAXBElement<CriarPerfil> createCriarPerfil(CriarPerfil value) {
        return new JAXBElement<CriarPerfil>(_CriarPerfil_QNAME, CriarPerfil.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarPerfilResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarPerfilResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "criar_perfilResponse")
    public JAXBElement<CriarPerfilResponse> createCriarPerfilResponse(CriarPerfilResponse value) {
        return new JAXBElement<CriarPerfilResponse>(_CriarPerfilResponse_QNAME, CriarPerfilResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarRestricao }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarRestricao }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "criar_restricao")
    public JAXBElement<CriarRestricao> createCriarRestricao(CriarRestricao value) {
        return new JAXBElement<CriarRestricao>(_CriarRestricao_QNAME, CriarRestricao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriarRestricaoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriarRestricaoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "criar_restricaoResponse")
    public JAXBElement<CriarRestricaoResponse> createCriarRestricaoResponse(CriarRestricaoResponse value) {
        return new JAXBElement<CriarRestricaoResponse>(_CriarRestricaoResponse_QNAME, CriarRestricaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostarMensagem }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PostarMensagem }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "postar_mensagem")
    public JAXBElement<PostarMensagem> createPostarMensagem(PostarMensagem value) {
        return new JAXBElement<PostarMensagem>(_PostarMensagem_QNAME, PostarMensagem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PostarMensagemResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PostarMensagemResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "postar_mensagemResponse")
    public JAXBElement<PostarMensagemResponse> createPostarMensagemResponse(PostarMensagemResponse value) {
        return new JAXBElement<PostarMensagemResponse>(_PostarMensagemResponse_QNAME, PostarMensagemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUtilizador }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUtilizador }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "registar_utilizador")
    public JAXBElement<RegistarUtilizador> createRegistarUtilizador(RegistarUtilizador value) {
        return new JAXBElement<RegistarUtilizador>(_RegistarUtilizador_QNAME, RegistarUtilizador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistarUtilizadorResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistarUtilizadorResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "registar_utilizadorResponse")
    public JAXBElement<RegistarUtilizadorResponse> createRegistarUtilizadorResponse(RegistarUtilizadorResponse value) {
        return new JAXBElement<RegistarUtilizadorResponse>(_RegistarUtilizadorResponse_QNAME, RegistarUtilizadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Restricao }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Restricao }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "restricao")
    public JAXBElement<Restricao> createRestricao(Restricao value) {
        return new JAXBElement<Restricao>(_Restricao_QNAME, Restricao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmsDescentralizada }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SmsDescentralizada }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "sms_descentralizada")
    public JAXBElement<SmsDescentralizada> createSmsDescentralizada(SmsDescentralizada value) {
        return new JAXBElement<SmsDescentralizada>(_SmsDescentralizada_QNAME, SmsDescentralizada.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SmsDescentralizadaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SmsDescentralizadaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "sms_descentralizadaResponse")
    public JAXBElement<SmsDescentralizadaResponse> createSmsDescentralizadaResponse(SmsDescentralizadaResponse value) {
        return new JAXBElement<SmsDescentralizadaResponse>(_SmsDescentralizadaResponse_QNAME, SmsDescentralizadaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Utilizador }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Utilizador }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicosImpl/", name = "utilizador")
    public JAXBElement<Utilizador> createUtilizador(Utilizador value) {
        return new JAXBElement<Utilizador>(_Utilizador_QNAME, Utilizador.class, null, value);
    }

}
