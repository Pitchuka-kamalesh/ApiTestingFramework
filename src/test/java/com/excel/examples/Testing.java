package com.excel.examples;

import utills.BaseClass;

public class Testing extends BaseClass {

    public Testing(){
        super();
    }

    public static void main(String[] args){

        Testing test = new Testing();

        System.out.println(locators_properties.getProperty("LOGIN_USERNAME"));

    }


}
