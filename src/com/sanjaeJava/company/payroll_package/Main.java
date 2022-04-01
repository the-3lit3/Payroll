package com.sanjaeJava.company.payroll_package;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        String fileName = "Pay_Stub.txt";
        Employee newEmp = new Employee();
        for(int i = 0; i <3; i++) {
            newEmp.getInfo();
            String x = newEmp.employeeInfo();
            List<String> employees = new ArrayList<>();
            employees.add(x);
        }
//        Employee [] com = {
//                new ComissionEmployee("san", "ball", "wieyu", 500, 5),
//                new BasePlusComissionEmployee("Jason", "Ball", "jb1234",20,25, 2500),
//                new SalariedEmployee("Keisha", "Flat Tumock", "KF2009", 4500),
//                new HourlyRate("Yendi", "Phillips", "YP3647", 350, 40)
//        };
//
//        System.out.println("===========================================================================================");
//        System.out.println("Employee payslip info...:");
//        for(int x = 0; x < com.length; x ++){
//            System.out.println("===========================================================================================\n");
//            com[x].display();
//            com[x].payAdvice();
//            System.out.println("===========================================================================================\n");
//
//        }

        //Invoice nvice = new Invoice("Toy-364","Toyota Altis Front Strut - Right", 2, 13000);
        Invoice defInv = new Invoice();
        defInv.getInfo();
        System.out.println("\nContractor/Customer Invoice Details...:");
        System.out.println("===========================================================================================\n");
        //nvice.display();
        defInv.getNxtInvoiceNumber();
        defInv.display();
        System.out.println("===========================================================================================\n");
        //nvice.payAdvice();
        defInv.payAdvice();



    }
}