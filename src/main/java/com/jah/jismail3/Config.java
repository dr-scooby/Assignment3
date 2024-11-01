package com.jah.jismail3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * Handle the configuration info from properties and from configmap.yaml files
 */

@Component
public class Config {

    @Value("${configvalue}")
    private String configValue;

    @Value("${secretvalue}")
    private String secretValue;

    @Value("${envirvariable}")
    private String envirVariable;

    @Value("${myfilename}")
    private String fileName;

    @Value("${myfilepath}")
    private String filePath;



    public Config() {
    }


    // ------ GET and SET methods ------


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
