package ru.neginskiy.tm.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-19T13:30:06.983+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "SessionEndpointService",
                  wsdlLocation = "http://localhost:1234/SessionEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.neginskiy.ru/")
public class SessionEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.neginskiy.ru/", "SessionEndpointService");
    public final static QName SessionEndpointPort = new QName("http://endpoint.tm.neginskiy.ru/", "SessionEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1234/SessionEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(SessionEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1234/SessionEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public SessionEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public SessionEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SessionEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public SessionEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public SessionEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public SessionEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns SessionEndpoint
     */
    @WebEndpoint(name = "SessionEndpointPort")
    public SessionEndpoint getSessionEndpointPort() {
        return super.getPort(SessionEndpointPort, SessionEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SessionEndpoint
     */
    @WebEndpoint(name = "SessionEndpointPort")
    public SessionEndpoint getSessionEndpointPort(WebServiceFeature... features) {
        return super.getPort(SessionEndpointPort, SessionEndpoint.class, features);
    }

}
