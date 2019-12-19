
package generated.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour message_retour complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="message_retour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coderetour" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="message_ret" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chemin" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message_retour", propOrder = {
    "coderetour",
    "messageRet",
    "chemin"
})
public class MessageRetour {

    protected int coderetour;
    @XmlElement(name = "message_ret", required = true)
    protected String messageRet;
    @XmlElement(required = true)
    protected String chemin;

    /**
     * Obtient la valeur de la propriété coderetour.
     * 
     */
    public int getCoderetour() {
        return coderetour;
    }

    /**
     * Définit la valeur de la propriété coderetour.
     * 
     */
    public void setCoderetour(int value) {
        this.coderetour = value;
    }

    /**
     * Obtient la valeur de la propriété messageRet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageRet() {
        return messageRet;
    }

    /**
     * Définit la valeur de la propriété messageRet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageRet(String value) {
        this.messageRet = value;
    }

    /**
     * Obtient la valeur de la propriété chemin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChemin() {
        return chemin;
    }

    /**
     * Définit la valeur de la propriété chemin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChemin(String value) {
        this.chemin = value;
    }

}
