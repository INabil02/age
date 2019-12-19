
package generated.pdf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour input complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="input">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="P_numadherent" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="P_Document" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="p_version" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "input", propOrder = {
    "pNumadherent",
    "pDocument",
    "pVersion"
})
public class Input {

    @XmlElement(name = "P_numadherent")
    protected int pNumadherent;
    @XmlElement(name = "P_Document", required = true)
    protected String pDocument;
    @XmlElement(name = "p_version")
    protected int pVersion;

    /**
     * Obtient la valeur de la propriété pNumadherent.
     * 
     */
    public int getPNumadherent() {
        return pNumadherent;
    }

    /**
     * Définit la valeur de la propriété pNumadherent.
     * 
     */
    public void setPNumadherent(int value) {
        this.pNumadherent = value;
    }

    /**
     * Obtient la valeur de la propriété pDocument.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPDocument() {
        return pDocument;
    }

    /**
     * Définit la valeur de la propriété pDocument.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPDocument(String value) {
        this.pDocument = value;
    }

    /**
     * Obtient la valeur de la propriété pVersion.
     * 
     */
    public int getPVersion() {
        return pVersion;
    }

    /**
     * Définit la valeur de la propriété pVersion.
     * 
     */
    public void setPVersion(int value) {
        this.pVersion = value;
    }

}
