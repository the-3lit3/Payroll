package com.sanjaeJava.company.payroll_package;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Test code.");
        Employee [] com = {
                new ComissionEmployee("san", "ball", "wieyu", 500, 5),
                new BasePlusComissionEmployee("Jason", "Ball", "jb1234",20,25, 2500),
                new SalariedEmployee("Keisha", "Flat Tumock", "KF2009", 4500),
                new HourlyRate("Yendi", "Phillips", "YP3647", 350, 40)
        };

        for(int x = 0; x < com.length; x ++){
            com[x].display();
            System.out.println("===========================================================================================\n");
        }



       //System.out.println("Output: " + com.getPaymentAmount()) ;
    }
}
