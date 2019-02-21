
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

    private final static QName _UncorrectSessionException_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "UncorrectSessionException");
    private final static QName _LoadDataBin_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataBin");
    private final static QName _LoadDataBinResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataBinResponse");
    private final static QName _LoadDataJson_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataJson");
    private final static QName _LoadDataJsonResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataJsonResponse");
    private final static QName _LoadDataXml_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataXml");
    private final static QName _LoadDataXmlResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "loadDataXmlResponse");
    private final static QName _SaveDataBin_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataBin");
    private final static QName _SaveDataBinResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataBinResponse");
    private final static QName _SaveDataJson_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataJson");
    private final static QName _SaveDataJsonResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataJsonResponse");
    private final static QName _SaveDataXml_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataXml");
    private final static QName _SaveDataXmlResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "saveDataXmlResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.neginskiy.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UncorrectSessionException }
     * 
     */
    public UncorrectSessionException createUncorrectSessionException() {
        return new UncorrectSessionException();
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
     * Create an instance of {@link LoadDataJson }
     * 
     */
    public LoadDataJson createLoadDataJson() {
        return new LoadDataJson();
    }

    /**
     * Create an instance of {@link LoadDataJsonResponse }
     * 
     */
    public LoadDataJsonResponse createLoadDataJsonResponse() {
        return new LoadDataJsonResponse();
    }

    /**
     * Create an instance of {@link LoadDataXml }
     * 
     */
    public LoadDataXml createLoadDataXml() {
        return new LoadDataXml();
    }

    /**
     * Create an instance of {@link LoadDataXmlResponse }
     * 
     */
    public LoadDataXmlResponse createLoadDataXmlResponse() {
        return new LoadDataXmlResponse();
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
     * Create an instance of {@link SaveDataJson }
     * 
     */
    public SaveDataJson createSaveDataJson() {
        return new SaveDataJson();
    }

    /**
     * Create an instance of {@link SaveDataJsonResponse }
     * 
     */
    public SaveDataJsonResponse createSaveDataJsonResponse() {
        return new SaveDataJsonResponse();
    }

    /**
     * Create an instance of {@link SaveDataXml }
     * 
     */
    public SaveDataXml createSaveDataXml() {
        return new SaveDataXml();
    }

    /**
     * Create an instance of {@link SaveDataXmlResponse }
     * 
     */
    public SaveDataXmlResponse createSaveDataXmlResponse() {
        return new SaveDataXmlResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UncorrectSessionException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "UncorrectSessionException")
    public JAXBElement<UncorrectSessionException> createUncorrectSessionException(UncorrectSessionException value) {
        return new JAXBElement<UncorrectSessionException>(_UncorrectSessionException_QNAME, UncorrectSessionException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDataJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "loadDataJson")
    public JAXBElement<LoadDataJson> createLoadDataJson(LoadDataJson value) {
        return new JAXBElement<LoadDataJson>(_LoadDataJson_QNAME, LoadDataJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDataJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "loadDataJsonResponse")
    public JAXBElement<LoadDataJsonResponse> createLoadDataJsonResponse(LoadDataJsonResponse value) {
        return new JAXBElement<LoadDataJsonResponse>(_LoadDataJsonResponse_QNAME, LoadDataJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDataXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "loadDataXml")
    public JAXBElement<LoadDataXml> createLoadDataXml(LoadDataXml value) {
        return new JAXBElement<LoadDataXml>(_LoadDataXml_QNAME, LoadDataXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadDataXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "loadDataXmlResponse")
    public JAXBElement<LoadDataXmlResponse> createLoadDataXmlResponse(LoadDataXmlResponse value) {
        return new JAXBElement<LoadDataXmlResponse>(_LoadDataXmlResponse_QNAME, LoadDataXmlResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDataJson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "saveDataJson")
    public JAXBElement<SaveDataJson> createSaveDataJson(SaveDataJson value) {
        return new JAXBElement<SaveDataJson>(_SaveDataJson_QNAME, SaveDataJson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDataJsonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "saveDataJsonResponse")
    public JAXBElement<SaveDataJsonResponse> createSaveDataJsonResponse(SaveDataJsonResponse value) {
        return new JAXBElement<SaveDataJsonResponse>(_SaveDataJsonResponse_QNAME, SaveDataJsonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDataXml }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "saveDataXml")
    public JAXBElement<SaveDataXml> createSaveDataXml(SaveDataXml value) {
        return new JAXBElement<SaveDataXml>(_SaveDataXml_QNAME, SaveDataXml.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveDataXmlResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "saveDataXmlResponse")
    public JAXBElement<SaveDataXmlResponse> createSaveDataXmlResponse(SaveDataXmlResponse value) {
        return new JAXBElement<SaveDataXmlResponse>(_SaveDataXmlResponse_QNAME, SaveDataXmlResponse.class, null, value);
    }

}
