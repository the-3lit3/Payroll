package com.sanjaeJava.company.payroll_package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SalariedEmployee extends Employee implements Payable{
    private double weeklySalary;
    private double hourlyRate;
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double wks){
        super(firstName, lastName, socialSecurityNumber);
        this.hourlyRate = wks;
        this.weeklySalary = 40 * hourlyRate;
    }

    public SalariedEmployee(){

    }

    Date date = new Date();
    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    DecimalFormat salaryFormatter = new DecimalFormat("0.00");

    public void setWeeklySalary(double wkSal){

        this.weeklySalary = wkSal;
    }

    @Override
    public void display(){
        System.out.println(dateFormatter.format(date));
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Salary : $" + salaryFormatter.format(weeklySalary));
    }

    @Override
    public void getInfo() {
        System.out.println(dateFormatter.format(date));
        Scanner scan = new Scanner(System.in);
        System.out.print("First Name : ");
        this.firstName = scan.nextLine();
        System.out.print("Last Name : ");
        this.lastName = scan.nextLine();
        System.out.print("SSE : ");
        this.socialSecurityNumber = scan.nextLine();
        System.out.print("Hourly Rate : $");
        this.hourlyRate = scan.nextDouble();

    }

    @Override
    public double getPaymentAmount(){

        return this.weeklySalary * this.hourlyRate;
    }

    @Override
    public void payAdvice() {
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("paystub.txt", true))){
            createPayStub.write("\n\n===========================================================================================\n\r" +
                    "Date : " + dateFormatter.format(date) + "\n\rEmployee Name : "+ this.getFirstName() + " "+ this.getLastName() +
                    "\n\rSalary : $ " + salaryFormatter.format(weeklySalary));
            System.out.println("Paystub Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }    }
}
