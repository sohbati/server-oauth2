package com.rsp.myserver.configuration.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:error-messages.properties")
public class ErrorMessagesConfig {
    @Autowired
    private Environment env;

    public String getErrorDescription(String errorCode) {
        return env.getProperty(errorCode);
    }
}