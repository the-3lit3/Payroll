package com.sanjaeJava.company.payroll_package;

public class SalariedEmployee extends Employee{
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
}
