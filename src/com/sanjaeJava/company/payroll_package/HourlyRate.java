package com.sanjaeJava.company.payroll_package;

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
}
