
package generated.pdf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.pdf package. 
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

    private final static QName _MessageRetour_QNAME = new QName("urn:Comp_GenDocument_AI", "message_retour");
    private final static QName _Input_QNAME = new QName("urn:Comp_GenDocument_AI", "input");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.pdf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Input }
     * 
     */
    public Input createInput() {
        return new Input();
    }

    /**
     * Create an instance of {@link MessageRetour }
     * 
     */
    public MessageRetour createMessageRetour() {
        return new MessageRetour();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageRetour }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:Comp_GenDocument_AI", name = "message_retour")
    public JAXBElement<MessageRetour> createMessageRetour(MessageRetour value) {
        return new JAXBElement<MessageRetour>(_MessageRetour_QNAME, MessageRetour.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Input }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:Comp_GenDocument_AI", name = "input")
    public JAXBElement<Input> createInput(Input value) {
        return new JAXBElement<Input>(_Input_QNAME, Input.class, null, value);
    }

}
