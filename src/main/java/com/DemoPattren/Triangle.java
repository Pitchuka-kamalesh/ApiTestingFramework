package com.DemoPattren;

public class Triangle {

/*    public static void StarleftTriangle(int k)
    {
        int a, b;

        // 1st loop
        for (a = 0; a < k; a++) {

            // nested 2nd loop
            for (b = 2 * (k - a); b >= 0; b--) {
//                System.out.println(2 * (k - a));
                // printing spaces
                System.out.print(" ");
            }

            // nested 3rd loop
            for (b = 0; b <= a; b++) {
                // printing stars
                System.out.print("* ");
            }

            // end-line
            System.out.println();
        }
    }

    // Driver Function
    public static void main(String args[])
    {
        int k = 5;
        StarleftTriangle(k);
    }*/

    public static void main(String[] args) {


        String pat = "* ";
//        for(int i = 1;i<=5;i++){
//            for (int j = 1; j<=i;j++){
//                System.out.print(pat);
//            }
//            System.out.println();
//        }
//        for (int i = 5;i>=1;i--){
//
//            for (int j = 1; j<=i;j++){
//                System.out.print(pat);
//            }
//            System.out.println();
//        }

        for (int i = 1; i <= 5; i++) {

            for (int j = 2*(5-i); j > 0; j--) {
                System.out.print(" ");

            }
            for (int k = 1; k <= i; k++) {
                System.out.print(pat);
            }

            System.out.println();
        }
    }


}
