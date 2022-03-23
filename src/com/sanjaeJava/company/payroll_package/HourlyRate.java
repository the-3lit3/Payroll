package com.sanjaeJava.company.payroll_package;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.RecursiveTask;

public class HourlyRate extends Employee implements Payable{
    private double wage;
    private double hours;

    public HourlyRate(String firstName, String lastName, String socialSecurityNumber,double wg, double hr){
        super(firstName, lastName, socialSecurityNumber);
        this.hours = wg; this.wage = hr;
    }

    public double getWage(){
        return this.wage;
    }

    public double getHours(){
        return this.hours;
    }

    @Override
    public double getPaymentAmount(){
        return this.wage * this.hours;
    }

    @Override
    public void display(){
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Hourly Rate : $" + this.wage);
        System.out.println("Hours Worked : " + this.hours);
        System.out.println("Salary : $" + this.getPaymentAmount());
    }

    @Override
    public void payAdvice() {
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
