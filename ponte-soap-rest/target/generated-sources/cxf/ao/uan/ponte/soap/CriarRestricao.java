
package ao.uan.ponte.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criar_restricao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criar_restricao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_restricao" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id_chave" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criar_restricao", propOrder = {
    "idRestricao",
    "idChave"
})
public class CriarRestricao {

    @XmlElement(name = "id_restricao")
    protected int idRestricao;
    @XmlElement(name = "id_chave")
    protected int idChave;

    /**
     * Gets the value of the idRestricao property.
     * 
     */
    public int getIdRestricao() {
        return idRestricao;
    }

    /**
     * Sets the value of the idRestricao property.
     * 
     */
    public void setIdRestricao(int value) {
        this.idRestricao = value;
    }

    /**
     * Gets the value of the idChave property.
     * 
     */
    public int getIdChave() {
        return idChave;
    }

    /**
     * Sets the value of the idChave property.
     * 
     */
    public void setIdChave(int value) {
        this.idChave = value;
    }

}
