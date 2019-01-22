
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

    private final static QName _UserDelete_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userDelete");
    private final static QName _UserDeleteResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userDeleteResponse");
    private final static QName _UserGetAll_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userGetAll");
    private final static QName _UserGetAllResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userGetAllResponse");
    private final static QName _UserGetById_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userGetById");
    private final static QName _UserGetByIdResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userGetByIdResponse");
    private final static QName _UserMerge_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userMerge");
    private final static QName _UserMergeResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userMergeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.neginskiy.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserDelete }
     * 
     */
    public UserDelete createUserDelete() {
        return new UserDelete();
    }

    /**
     * Create an instance of {@link UserDeleteResponse }
     * 
     */
    public UserDeleteResponse createUserDeleteResponse() {
        return new UserDeleteResponse();
    }

    /**
     * Create an instance of {@link UserGetAll }
     * 
     */
    public UserGetAll createUserGetAll() {
        return new UserGetAll();
    }

    /**
     * Create an instance of {@link UserGetAllResponse }
     * 
     */
    public UserGetAllResponse createUserGetAllResponse() {
        return new UserGetAllResponse();
    }

    /**
     * Create an instance of {@link UserGetById }
     * 
     */
    public UserGetById createUserGetById() {
        return new UserGetById();
    }

    /**
     * Create an instance of {@link UserGetByIdResponse }
     * 
     */
    public UserGetByIdResponse createUserGetByIdResponse() {
        return new UserGetByIdResponse();
    }

    /**
     * Create an instance of {@link UserMerge }
     * 
     */
    public UserMerge createUserMerge() {
        return new UserMerge();
    }

    /**
     * Create an instance of {@link UserMergeResponse }
     * 
     */
    public UserMergeResponse createUserMergeResponse() {
        return new UserMergeResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDelete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userDelete")
    public JAXBElement<UserDelete> createUserDelete(UserDelete value) {
        return new JAXBElement<UserDelete>(_UserDelete_QNAME, UserDelete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userDeleteResponse")
    public JAXBElement<UserDeleteResponse> createUserDeleteResponse(UserDeleteResponse value) {
        return new JAXBElement<UserDeleteResponse>(_UserDeleteResponse_QNAME, UserDeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGetAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userGetAll")
    public JAXBElement<UserGetAll> createUserGetAll(UserGetAll value) {
        return new JAXBElement<UserGetAll>(_UserGetAll_QNAME, UserGetAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGetAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userGetAllResponse")
    public JAXBElement<UserGetAllResponse> createUserGetAllResponse(UserGetAllResponse value) {
        return new JAXBElement<UserGetAllResponse>(_UserGetAllResponse_QNAME, UserGetAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGetById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userGetById")
    public JAXBElement<UserGetById> createUserGetById(UserGetById value) {
        return new JAXBElement<UserGetById>(_UserGetById_QNAME, UserGetById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserGetByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userGetByIdResponse")
    public JAXBElement<UserGetByIdResponse> createUserGetByIdResponse(UserGetByIdResponse value) {
        return new JAXBElement<UserGetByIdResponse>(_UserGetByIdResponse_QNAME, UserGetByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserMerge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userMerge")
    public JAXBElement<UserMerge> createUserMerge(UserMerge value) {
        return new JAXBElement<UserMerge>(_UserMerge_QNAME, UserMerge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserMergeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "userMergeResponse")
    public JAXBElement<UserMergeResponse> createUserMergeResponse(UserMergeResponse value) {
        return new JAXBElement<UserMergeResponse>(_UserMergeResponse_QNAME, UserMergeResponse.class, null, value);
    }

}
