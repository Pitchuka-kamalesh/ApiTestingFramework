package com.excel.examples;

import com.varibles.ConfigProperties;
import utills.BaseClass;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import static com.varibles.ConfigProperties.properties;

public class Testing extends BaseClass {

    public Testing(){
        super();
    }

    public static void main(String[] args){

        Testing test = new Testing();

        System.out.println(locators_properties.getProperty("LOGIN_USERNAME"));

    }


}
