package com.demoTest;

/**
 * 
 */
public class PraticesTest2 {

	/*
	 * // when we write two main methods we are will get an error duplicates main
	 * methods but runs first main methods.
	 * 
	 * 
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("Hello World");
	 * 
	 * }
	 */

	/**
	 * Error: Main method not found in class com.demoTest.PraticesTest2, please
	 * define the main method as: public static void main(String[] args) or a JavaFX
	 * application class must extend javafx.application.Application
	 * 
	 * 
	 */

	public static void main(Integer[] args) {

		System.out.println(args);

	}

	/**
	 * // Error: Main method not found in class com.demoTest.PraticesTest2, please
	 * define the main method as: public static void main(String[] args) or a JavaFX
	 * application class must extend javafx.application.Application
	 */
	public static void main(int[] args) {

		System.out.println("Test2 with main with int" + args);

	}

	/**
	 * // Exception in thread "main" java.lang.Error: Unresolved compilation
	 * problem: // The method main(String[]) of type PraticesTest2 must override or
	 * implement a supertype method // // at
	 * com.demoTest.PraticesTest2.main(PraticesTest2.java:40)
	 */
	public static void main(String[] args) {

		System.out.println("Test2 with main with string");
		int[] test = { 10, 20 };
		Integer[] testi = { 10, 20 };
		PraticesTest2.main(testi);
		PraticesTest2.main(test);
		

	}

}
