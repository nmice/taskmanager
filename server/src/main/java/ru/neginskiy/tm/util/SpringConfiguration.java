package ru.neginskiy.tm.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean(name="myBean")
    public HelloWorld getHelloWorld(){
        return new HelloWorld();
    }
}
