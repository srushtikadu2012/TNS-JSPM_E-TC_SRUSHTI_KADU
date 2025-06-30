package com.assignment_1;

public class checkprime_no {

	public static void main(String[] args) {
		 int number = 29; 
	        boolean isPrime = true;

	        if (number <= 1) {
	            isPrime = false;
	        } else {
	           
	            for (int i = 2; i <= Math.sqrt(number); i++) {
	                if (number % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }

	        if (isPrime) {
	            System.out.println(number + " is a Prime number.");
	        } else {
	            System.out.println(number + " is not a Prime number.");
	        }
	}

}
