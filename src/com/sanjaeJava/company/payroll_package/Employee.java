package com.sanjaeJava.company.payroll_package;

import org.w3c.dom.Text;

import java.io.IOException;

public class Employee implements Payable{
    protected String firstName;
    protected String lastName;
    protected String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public void payAdvice(){

    }

    @Override
    public void display(){
        System.out.println("First Name : "+ this.firstName);
        System.out.println("Last Name : "+ this.lastName);
        System.out.println("Social Security # : "+ this.socialSecurityNumber);
    }

}
