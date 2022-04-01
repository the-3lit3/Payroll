package com.sanjaeJava.company.payroll_package;

import java.util.Scanner;

public class Employee{
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public Employee(){}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

//    @Override
//    public double getPaymentAmount() {
//        return 0;
//    }
//
//    @Override
//    public void payAdvice(){
//
//    }
//
//    @Override
    public void display(){
        System.out.println("First Name : "+ this.firstName);
        System.out.println("Last Name : "+ this.lastName);
        System.out.println("Social Security # : "+ this.socialSecurityNumber);
    }

    //@Override
    public void getInfo() {
        Scanner info = new Scanner(System.in);
        System.out.print("First Name : ");
        this.firstName = info.nextLine();
        System.out.print("Last Name : ");
        this.lastName = info.nextLine();
        System.out.print("SSN : ");
        this.socialSecurityNumber = info.nextLine();

    }

}
