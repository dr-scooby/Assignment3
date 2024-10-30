package com.jah.jismail3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * Handle the configuration from properties and from configmap.yaml files
 */

@Component
public class Config {

    @Value("${configvalue}")
    private String configValue;

    @Value("${secretvalue}")
    private String secretValue;

    @Value("${envirvariable}")
    private String envirVariable;


    public Config() {
    }


    // ------ GET and SET methods ------
    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getSecretValue() {
        return secretValue;
    }

    public void setSecretValue(String secretValue) {
        this.secretValue = secretValue;
    }

    public String getEnvirVariable() {
        return envirVariable;
    }

    public void setEnvirVariable(String envirVariable) {
        this.envirVariable = envirVariable;
    }


    @Override
    public String toString() {
        return "Config{" +
                "configValue='" + configValue + '\'' +
                ", secretValue='" + secretValue + '\'' +
                ", envirVariable='" + envirVariable + '\'' +
                '}';
    }
}
