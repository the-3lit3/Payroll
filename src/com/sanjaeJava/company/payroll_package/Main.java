package com.sanjaeJava.company.payroll_package;
import java.io.IOException;

public class Main {

    public static void main(String[] args){

        Employee [] com = {
                new ComissionEmployee("san", "ball", "wieyu", 500, 5),
                new BasePlusComissionEmployee("Jason", "Ball", "jb1234",20,25, 2500),
                new SalariedEmployee("Keisha", "Flat Tumock", "KF2009", 4500),
                new HourlyRate("Yendi", "Phillips", "YP3647", 350, 40)
        };

        System.out.println("===========================================================================================");
        System.out.println("Employee payslip info...:");
        for(int x = 0; x < com.length; x ++){
            System.out.println("===========================================================================================\n");
            com[x].display();
            com[x].payAdvice();
            System.out.println("===========================================================================================\n");

        }

        Invoice nvice = new Invoice("Toy-364","Toyota Altis Front Strut - Right", 2, 13000);
        System.out.println("\nContractor Invoice Details...:");
        System.out.println("===========================================================================================\n");
        nvice.display();
        System.out.println("===========================================================================================\n");
        nvice.payAdvice();

    }
}
