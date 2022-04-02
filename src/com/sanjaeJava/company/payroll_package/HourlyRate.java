package com.sanjaeJava.company.payroll_package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class HourlyRate extends Employee implements Payable{
    private double wage;
    private double hours;

    public HourlyRate(String firstName, String lastName, String socialSecurityNumber,double wg, double hr){
        super(firstName, lastName, socialSecurityNumber);
        this.hours = wg; this.wage = hr;
    }

    public HourlyRate(){}

    public void setWage(double wg){
        this.wage = wg;
    }

    public void setHours(double hrs){
        this.hours = hrs;
    }

//    public double getWage(){
//        return this.wage;
//    }
//
//    public double getHours(){
//        return this.hours;
//    }

    Date date = new Date();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat salaryFormatter = new DecimalFormat("0.00");
    Scanner scan = new Scanner(System.in);

    @Override
    public double getPaymentAmount(){
        return this.wage * this.hours;
    }

    @Override
    public void display(){
        System.out.println(dateFormatter.format(date));
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Hourly Rate : $" + this.wage);
        System.out.println("Hours Worked : " + this.hours);
        System.out.println("Salary : $" + salaryFormatter.format(getPaymentAmount()));
    }

    @Override
    public void getInfo() {
        System.out.println(dateFormatter.format(date));
        System.out.print("First Name : ");
        this.firstName = scan.nextLine();
        System.out.print("Last Name : ");
        this.lastName = scan.nextLine();
        System.out.print("SSE : ");
        this.socialSecurityNumber = scan.nextLine();
        System.out.print("Hours Worked : ");
        this.hours = scan.nextDouble();
        System.out.print("Hourly Rate : $");
        this.wage = scan.nextDouble();

    }

    @Override
    public String payAdvice() {
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("paystub.txt", true))){
            createPayStub.write("\n\n===========================================================================================\n\r" +
                    "Date : " + dateFormatter.format(date) + "\n\rEmployee Name : "+ this.getFirstName() + " "+ this.getLastName() +
                    "\n\rSalary : $ " + salaryFormatter.format(getPaymentAmount()));
            System.out.println("Paystub Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
