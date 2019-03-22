package ru.neginskiy.tm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.neginskiy.tm.endpoint.*;

@ComponentScan("ru.neginskiy.tm")
@Configuration
public class AppConfig {

    @Bean
    public TaskEndpoint getTaskEndpoint() {
        return new TaskEndpointService().getTaskEndpointPort();
    }

    @Bean
    public UserEndpoint getUserEndpointService() {
        return new UserEndpointService().getUserEndpointPort();
    }

    @Bean
    public SessionEndpoint getSessionEndpointService() {
        return new SessionEndpointService().getSessionEndpointPort();
    }

    @Bean
    public DataEndpoint getDataEndpointService() {
        return new DataEndpointService().getDataEndpointPort();
    }

    @Bean
    public ProjectEndpoint getProjectEndpointService() {
        return new ProjectEndpointService().getProjectEndpointPort();
    }
}
