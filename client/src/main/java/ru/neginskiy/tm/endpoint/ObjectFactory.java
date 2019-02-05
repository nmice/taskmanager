
package ru.neginskiy.tm.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.neginskiy.tm.endpoint package. 
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

    private final static QName _LoadDataBin_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataBin");
    private final static QName _LoadDataBinResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataBinResponse");
    private final static QName _SaveDataBin_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataBin");
    private final static QName _SaveDataBinResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataBinResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.neginskiy.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoadDataBin }
     * 
     */
    public LoadDataBin createLoadDataBin() {
        return new LoadDataBin();
    }

    /**
     * Create an instance of {@link LoadDataBinResponse }
     * 
     */
    public LoadDataBinResponse createLoadDataBinResponse() {
        return new LoadDataBinResponse();
    }

    /**
     * Create an instance of {@link SaveDataBin }
     * 
     */
    public SaveDataBin createSaveDataBin() {
        return new SaveDataBin();
    }

    /**
     * Create an instance of {@link SaveDataBinResponse }
     * 
     */
    public SaveDataBinResponse createSaveDataBinResponse() {
        return new SaveDataBinResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDataBin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "loadDataBin")
    public JAXBElement<LoadDataBin> createLoadDataBin(LoadDataBin value) {
        return new JAXBElement<LoadDataBin>(_LoadDataBin_QNAME, LoadDataBin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDataBinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "loadDataBinResponse")
    public JAXBElement<LoadDataBinResponse> createLoadDataBinResponse(LoadDataBinResponse value) {
        return new JAXBElement<LoadDataBinResponse>(_LoadDataBinResponse_QNAME, LoadDataBinResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDataBin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "saveDataBin")
    public JAXBElement<SaveDataBin> createSaveDataBin(SaveDataBin value) {
        return new JAXBElement<SaveDataBin>(_SaveDataBin_QNAME, SaveDataBin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDataBinResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "saveDataBinResponse")
    public JAXBElement<SaveDataBinResponse> createSaveDataBinResponse(SaveDataBinResponse value) {
        return new JAXBElement<SaveDataBinResponse>(_SaveDataBinResponse_QNAME, SaveDataBinResponse.class, null, value);
    }

}
