package com.assignment_1;

public class BloodDonationEligibility {
	public static void main(String[] args) {
        int age = 20;     
        int weight = 55;  

        if (age >= 18 && weight >= 50) {
            System.out.println("You are eligible to donate blood.");
        } else {
            System.out.println("You are not eligible to donate blood.");
        }
    }
}
