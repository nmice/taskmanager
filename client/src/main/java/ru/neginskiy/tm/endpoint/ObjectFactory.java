
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

    private final static QName _FindUser_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "findUser");
    private final static QName _FindUserResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "findUserResponse");
    private final static QName _IsRegistredLogin_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "isRegistredLogin");
    private final static QName _IsRegistredLoginResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "isRegistredLoginResponse");
    private final static QName _UserMerge_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userMerge");
    private final static QName _UserMergeResponse_QNAME = new QName("http://endpoint.tm.neginskiy.ru/", "userMergeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.neginskiy.tm.endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindUser }
     * 
     */
    public FindUser createFindUser() {
        return new FindUser();
    }

    /**
     * Create an instance of {@link FindUserResponse }
     * 
     */
    public FindUserResponse createFindUserResponse() {
        return new FindUserResponse();
    }

    /**
     * Create an instance of {@link IsRegistredLogin }
     * 
     */
    public IsRegistredLogin createIsRegistredLogin() {
        return new IsRegistredLogin();
    }

    /**
     * Create an instance of {@link IsRegistredLoginResponse }
     * 
     */
    public IsRegistredLoginResponse createIsRegistredLoginResponse() {
        return new IsRegistredLoginResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "findUser")
    public JAXBElement<FindUser> createFindUser(FindUser value) {
        return new JAXBElement<FindUser>(_FindUser_QNAME, FindUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "findUserResponse")
    public JAXBElement<FindUserResponse> createFindUserResponse(FindUserResponse value) {
        return new JAXBElement<FindUserResponse>(_FindUserResponse_QNAME, FindUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsRegistredLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "isRegistredLogin")
    public JAXBElement<IsRegistredLogin> createIsRegistredLogin(IsRegistredLogin value) {
        return new JAXBElement<IsRegistredLogin>(_IsRegistredLogin_QNAME, IsRegistredLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsRegistredLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint.tm.neginskiy.ru/", name = "isRegistredLoginResponse")
    public JAXBElement<IsRegistredLoginResponse> createIsRegistredLoginResponse(IsRegistredLoginResponse value) {
        return new JAXBElement<IsRegistredLoginResponse>(_IsRegistredLoginResponse_QNAME, IsRegistredLoginResponse.class, null, value);
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
