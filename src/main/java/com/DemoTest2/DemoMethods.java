package com.DemoTest2;

public class DemoMethods {

	public int returnDefaultIntegerValue() {
		int a = 10;

		System.out.println("");

		return a;
	}

	public int returnAllIntegerValue(int[] args) {
		int sum = 0;
		for (int a : args) {
			System.out.println(a);
			sum = sum + a;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println();

	}

	public int returnDefaultIntergerValue() {
		// TODO Auto-generated method stub
		System.out.println("Main implementation");
		return 0;
	}

}
