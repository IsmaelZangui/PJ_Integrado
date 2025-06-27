
package ao.uan.ponte.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for postar_mensagem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="postar_mensagem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="utilizador" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="restricao" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="local" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="data_fim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hora_fim" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="modo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postar_mensagem", propOrder = {
    "utilizador",
    "restricao",
    "mensagem",
    "titulo",
    "local",
    "data",
    "hora",
    "dataFim",
    "horaFim",
    "modo"
})
public class PostarMensagem {

    protected int utilizador;
    protected int restricao;
    protected String mensagem;
    protected String titulo;
    protected int local;
    protected String data;
    protected String hora;
    @XmlElement(name = "data_fim")
    protected String dataFim;
    @XmlElement(name = "hora_fim")
    protected String horaFim;
    protected String modo;

    /**
     * Gets the value of the utilizador property.
     * 
     */
    public int getUtilizador() {
        return utilizador;
    }

    /**
     * Sets the value of the utilizador property.
     * 
     */
    public void setUtilizador(int value) {
        this.utilizador = value;
    }

    /**
     * Gets the value of the restricao property.
     * 
     */
    public int getRestricao() {
        return restricao;
    }

    /**
     * Sets the value of the restricao property.
     * 
     */
    public void setRestricao(int value) {
        this.restricao = value;
    }

    /**
     * Gets the value of the mensagem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Sets the value of the mensagem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Gets the value of the titulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Gets the value of the local property.
     * 
     */
    public int getLocal() {
        return local;
    }

    /**
     * Sets the value of the local property.
     * 
     */
    public void setLocal(int value) {
        this.local = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setData(String value) {
        this.data = value;
    }

    /**
     * Gets the value of the hora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHora() {
        return hora;
    }

    /**
     * Sets the value of the hora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHora(String value) {
        this.hora = value;
    }

    /**
     * Gets the value of the dataFim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * Sets the value of the dataFim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFim(String value) {
        this.dataFim = value;
    }

    /**
     * Gets the value of the horaFim property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraFim() {
        return horaFim;
    }

    /**
     * Sets the value of the horaFim property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraFim(String value) {
        this.horaFim = value;
    }

    /**
     * Gets the value of the modo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModo() {
        return modo;
    }

    /**
     * Sets the value of the modo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModo(String value) {
        this.modo = value;
    }

}
