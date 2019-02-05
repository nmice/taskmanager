
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

    private final static QName _GetNewSession_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "getNewSession");
    private final static QName _GetNewSessionResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "getNewSessionResponse");
    private final static QName _SessionDelete_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "sessionDelete");
    private final static QName _SessionDeleteResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "sessionDeleteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.neginskiy.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNewSession }
     * 
     */
    public GetNewSession createGetNewSession() {
        return new GetNewSession();
    }

    /**
     * Create an instance of {@link GetNewSessionResponse }
     * 
     */
    public GetNewSessionResponse createGetNewSessionResponse() {
        return new GetNewSessionResponse();
    }

    /**
     * Create an instance of {@link SessionDelete }
     * 
     */
    public SessionDelete createSessionDelete() {
        return new SessionDelete();
    }

    /**
     * Create an instance of {@link SessionDeleteResponse }
     * 
     */
    public SessionDeleteResponse createSessionDeleteResponse() {
        return new SessionDeleteResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "getNewSession")
    public JAXBElement<GetNewSession> createGetNewSession(GetNewSession value) {
        return new JAXBElement<GetNewSession>(_GetNewSession_QNAME, GetNewSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNewSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "getNewSessionResponse")
    public JAXBElement<GetNewSessionResponse> createGetNewSessionResponse(GetNewSessionResponse value) {
        return new JAXBElement<GetNewSessionResponse>(_GetNewSessionResponse_QNAME, GetNewSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "sessionDelete")
    public JAXBElement<SessionDelete> createSessionDelete(SessionDelete value) {
        return new JAXBElement<SessionDelete>(_SessionDelete_QNAME, SessionDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SessionDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "sessionDeleteResponse")
    public JAXBElement<SessionDeleteResponse> createSessionDeleteResponse(SessionDeleteResponse value) {
        return new JAXBElement<SessionDeleteResponse>(_SessionDeleteResponse_QNAME, SessionDeleteResponse.class, null, value);
    }

}
