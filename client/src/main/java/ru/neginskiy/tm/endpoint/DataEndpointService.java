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
 * 2019-02-08T13:03:33.238+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "DataEndpointService",
                  wsdlLocation = "http://localhost:1234/DataEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.neginskiy.ru/")
public class DataEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.neginskiy.ru/", "DataEndpointService");
    public final static QName DataEndpointPort = new QName("http://endpoint.tm.neginskiy.ru/", "DataEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1234/DataEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(DataEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1234/DataEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public DataEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public DataEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DataEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public DataEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public DataEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public DataEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns DataEndpoint
     */
    @WebEndpoint(name = "DataEndpointPort")
    public DataEndpoint getDataEndpointPort() {
        return super.getPort(DataEndpointPort, DataEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DataEndpoint
     */
    @WebEndpoint(name = "DataEndpointPort")
    public DataEndpoint getDataEndpointPort(WebServiceFeature... features) {
        return super.getPort(DataEndpointPort, DataEndpoint.class, features);
    }

}
