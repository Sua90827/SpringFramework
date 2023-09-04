package com.care.test02;

public class OperationClass {

	public int operation(int num1, int num2, String op) {
		System.out.println("¿©±â ¿È");

		int result=0;
		if(op.equals("+")) {
			result= num1+num2;
		}else if(op.equals("-")) {
			result = num1 - num2;
		}else if (op.equals("*")) {
			result=num1*num2;
		}else if(op.equals( "/")) {
			result=num1/num2;
		}
		return result;
	}

}
