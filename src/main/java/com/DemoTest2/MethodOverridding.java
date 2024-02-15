package com.DemoTest2;

public class MethodOverridding extends DemoMethods {
	
	@Override
	public int returnDefaultIntergerValue() {
		int b = 20;
		System.out.println("Welcome to the overridding method");
		
		return b;

	}
	
	
	public static void main(String[] args) {
		
		MethodOverridding mo = new MethodOverridding();
		
		System.out.println(mo.returnDefaultIntergerValue());
		System.out.println(mo.returnDefaultIntegerValue());
		System.out.println(mo.returnDefaultIntergerValue());
	}
	

}
