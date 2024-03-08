package com.varibles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    public static Properties properties;
    private static final String conFigPath = "configuration/configuration.properties";

    public static void initializePropertiesFile(){
        properties = new Properties();
        try {
            InputStream ip = new FileInputStream(conFigPath);
            properties.load(ip);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
