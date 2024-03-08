package com.Democonverction;

public class Converction {

    public Converction(String value){
        System.out.println("This is a constructor");
        System.out.println(value);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        Converction cov = new Converction("Hello world");
        int value = cov.ConStrToInt("2020f");
        System.out.println(value);

        String value1 = new String("Hello world");
        String value2 = "Hello World";
        System.out.println(value1.equals(value2));
        if (value1 == value2) {
            System.out.println("the values are equal");
        } else {
            System.out.println("the values are not equals");
        }
        if (value1.equalsIgnoreCase(value2)) {

            System.out.println(" both strings are equal with ignoring the string");
        } else {
            System.out.println(" both string are not equal");
        }


    }

    public String convIntToStr(int value) {

        return Integer.toString(value);
    }

    public Integer ConStrToInt(String value) {
        int rep = 0;
        try {
            rep = Integer.parseInt(value);
            return rep;
        } catch (Exception e) {
            System.out.println(" given value is can't converted to integer value");
            return rep;

        }

    }
}
