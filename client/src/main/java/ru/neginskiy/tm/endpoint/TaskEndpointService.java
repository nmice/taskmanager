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
 * 2019-02-13T11:31:34.819+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "TaskEndpointService",
                  wsdlLocation = "http://localhost:1234/TaskEndpoint?wsdl",
                  targetNamespace = "http://endpoint.tm.neginskiy.ru/")
public class TaskEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.neginskiy.ru/", "TaskEndpointService");
    public final static QName TaskEndpointPort = new QName("http://endpoint.tm.neginskiy.ru/", "TaskEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1234/TaskEndpoint?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(TaskEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:1234/TaskEndpoint?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public TaskEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TaskEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TaskEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public TaskEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public TaskEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TaskEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns TaskEndpoint
     */
    @WebEndpoint(name = "TaskEndpointPort")
    public TaskEndpoint getTaskEndpointPort() {
        return super.getPort(TaskEndpointPort, TaskEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TaskEndpoint
     */
    @WebEndpoint(name = "TaskEndpointPort")
    public TaskEndpoint getTaskEndpointPort(WebServiceFeature... features) {
        return super.getPort(TaskEndpointPort, TaskEndpoint.class, features);
    }

}
