package com.sanjaeJava.company.payroll_package;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;

public class BasePlusComissionEmployee extends ComissionEmployee implements Payable{
    private double baseSalary;
    public BasePlusComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double gs, double cr,double bs){
        super(firstName, lastName, socialSecurityNumber, gs, cr);
        this.baseSalary = bs;
    }

    public BasePlusComissionEmployee(){
    }

    Date date = new Date();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    String newDate = dateFormatter.format(date);
    DecimalFormat salaryFormatter = new DecimalFormat("0.00");
    @Override
    public double getPaymentAmount(){
        double cSal = (getGrossSales() * getComissionRate()) + this.baseSalary;
        return cSal;
    }

    @Override
    public void display(){
        System.out.println("Date : " + newDate);
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Gross Sales : " + getGrossSales());
        System.out.println("ComissionRate : " + getComissionRate());
        System.out.println("Salary : $" + salaryFormatter.format(getPaymentAmount()));
    }
//
//    @Override
//    public void getInfo() {
//
//    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public void payAdvice(){
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("paystub.txt", true))){
            createPayStub.write("\n\n===========================================================================================\n\r" +
                    "Date : " + newDate + "\n\rEmployee Name : "+ this.getFirstName() + " "+ this.getLastName() +
                    "\n\rSalary : $ " + salaryFormatter.format(getPaymentAmount()));
            System.out.println("Paystub Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
