package ru.neginskiy.tm.producer;

import ru.neginskiy.tm.endpoint.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class EndpointsProducer {

    @Produces
    @ApplicationScoped
    public TaskEndpoint getTaskEndpoint() {
        return new TaskEndpointService().getTaskEndpointPort();
    }

    @Produces
    @ApplicationScoped
    public UserEndpoint getUserEndpointService() {
        return new UserEndpointService().getUserEndpointPort();
    }
    @Produces
    @ApplicationScoped
    public SessionEndpoint getSessionEndpointService() {
        return new SessionEndpointService().getSessionEndpointPort();
    }

    @Produces
    @ApplicationScoped
    public DataEndpoint getDataEndpointService() {
        return new DataEndpointService().getDataEndpointPort();
    }

    @Produces
    @ApplicationScoped
    public ProjectEndpoint getProjectEndpointService() {
        return new ProjectEndpointService().getProjectEndpointPort();
    }
}
