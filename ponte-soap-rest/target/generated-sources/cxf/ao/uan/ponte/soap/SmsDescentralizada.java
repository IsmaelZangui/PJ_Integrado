
package ao.uan.ponte.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sms_descentralizada complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sms_descentralizada"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_utilizador" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sms_descentralizada", propOrder = {
    "idUtilizador"
})
public class SmsDescentralizada {

    @XmlElement(name = "id_utilizador")
    protected int idUtilizador;

    /**
     * Gets the value of the idUtilizador property.
     * 
     */
    public int getIdUtilizador() {
        return idUtilizador;
    }

    /**
     * Sets the value of the idUtilizador property.
     * 
     */
    public void setIdUtilizador(int value) {
        this.idUtilizador = value;
    }

}
