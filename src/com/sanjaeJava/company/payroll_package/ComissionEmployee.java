package com.sanjaeJava.company.payroll_package;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComissionEmployee extends Employee implements Payable{
    private double grossSales;
    private double comissionRate;
    public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double gs, double cr){
        super(firstName, lastName, socialSecurityNumber);
        this.comissionRate = gs;
        this.grossSales = cr;
    }

    @Override
    public double getPaymentAmount(){

        return this.grossSales * this.comissionRate;
    }

    @Override
    public void display(){
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Gross Sales : " + this.grossSales);
        System.out.println("ComissionRate : " + this.comissionRate);
        System.out.println("Salary : $" + this.getPaymentAmount());
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(double comissionRate) {
        this.comissionRate = comissionRate;
    }

    @Override
    public void payAdvice(){
        LocalDate now = LocalDate.now();
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("paystub.txt", true))){
            createPayStub.write("\n\n===========================================================================================\n\r" +
                    "Date : " + now + "\n\rEmployee Name : "+ this.getFirstName() + " "+ this.getLastName() +
                    "\n\rSalary : $ " + (int) getPaymentAmount());
            System.out.println("Paystub Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }


    }

}
