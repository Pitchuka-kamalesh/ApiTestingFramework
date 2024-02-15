package com.DemoPattren;

public class Triangle {

    public static String pat = "* ";

    public static void main(String[] args) {


    }

    public void leftTriangle(int k) {

        for (int rows = 0; rows < k; rows++) {

            for (int col = 0; col <= rows; col++) {
                System.out.print(pat);
            }
            System.out.println();

        }
    }

    public void rightTriangle(int k) {

    }

    public void primed(int k) {

    }

}


