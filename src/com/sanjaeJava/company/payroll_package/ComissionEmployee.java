package com.sanjaeJava.company.payroll_package;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ComissionEmployee extends Employee implements Payable{
    private double grossSales;
    private double comissionRate;

    public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double gs, double cr){
        super(firstName, lastName, socialSecurityNumber);
        this.comissionRate = gs;
        this.grossSales = cr;
    }

    public ComissionEmployee(){}

    @Override
    public double getPaymentAmount(){

        return this.grossSales * this.comissionRate;
    }

    public void getInfo(){
        Scanner scan = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date : " + dateFormatter.format(date));
        System.out.println("First Name : ");
        this.firstName = scan.nextLine();
        System.out.println("Last Name : ");
        this.lastName = scan.nextLine();
        System.out.println("SSN : ");
        this.socialSecurityNumber = scan.nextLine();
        System.out.println("Commission Rate (In percentage) : ");
        this.comissionRate = scan.nextDouble();
        System.out.println("Gross Sales :\t$");
        this.grossSales = scan.nextDouble();
        }

    @Override
    public void display(){
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat salaryFormatter = new DecimalFormat("0.00");
        System.out.println("Date : " + dateFormatter.format(date));
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Gross Sales : " + this.grossSales);
        System.out.println("ComissionRate : " + this.comissionRate);
        System.out.println("Salary : $" + salaryFormatter.format(getPaymentAmount()));
    }

    public double getGrossSales() {
        return grossSales;
    }

    public double getComissionRate() {
        return comissionRate;
    }

    @Override
    public void payAdvice(){
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat SalaryFormatter = new DecimalFormat("0.00");
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("paystub.txt", true))){
            createPayStub.write("\n\n===========================================================================================\n\r" +
                    "Date : " + dateFormatter.format(date) + "\n\rEmployee Name : "+ this.getFirstName() + " "+ this.getLastName() +
                    "\n\rSalary : $ " + SalaryFormatter.format(getPaymentAmount()));
            System.out.println("Paystub Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }


    }

}