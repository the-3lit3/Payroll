package com.sanjaeJava.company.payroll_package;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalariedEmployee extends Employee implements Payable{
    private double weeklySalary;
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double wks){
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = wks;
    }

    public double getWeeklySalary(){

        return weeklySalary ;
    }

    @Override
    public void display(){
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        //System.out.println("Gross Sales : " + this.grossSales);
        //System.out.println("ComissionRate : " + this.comissionRate);
        System.out.println("Salary : $" + this.weeklySalary);
    }

    @Override
    public void payAdvice() {
        LocalDate now = LocalDate.now();
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("paystub.txt", true))){
            createPayStub.write("\n\n===========================================================================================\n\r" +
                    "Date : " + now + "\n\rEmployee Name : "+ this.getFirstName() + " "+ this.getLastName() +
                    "\n\rSalary : $ " + this.weeklySalary);
            System.out.println("Paystub Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }    }
}
