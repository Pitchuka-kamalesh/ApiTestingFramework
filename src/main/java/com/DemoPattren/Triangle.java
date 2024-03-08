package com.DemoPattren;

public class Triangle {

    public static String pat = "* ";

    public static void main(String[] args) {

        int k = 5;
        Triangle tri = new Triangle();
        tri.rightTriangle(k);
//        tri.leftTriangle(k);
//        tri.primed(k);


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


        for (int rows = 0; rows < k; rows++) {

            for (int spa = 2 * (k - rows); spa > 0; spa--) {
                System.out.print(" ");
            }

            for (int col = 0; col <= rows; col++) {
                System.out.print(pat);
            }
            System.out.println();

        }


    }

    public void primed(int k) {


        for (int rows = 0; rows < k; rows++) {

            for (int spa = (k-rows); spa > 1; spa--) {
                System.out.print(" ");
            }

            for (int col = 0; col <= rows; col++) {
                System.out.print(pat);
            }
            System.out.println();

        }

    }

}


