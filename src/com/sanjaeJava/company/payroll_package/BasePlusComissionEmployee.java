package com.sanjaeJava.company.payroll_package;

public class BasePlusComissionEmployee extends ComissionEmployee implements Payable{
    private double baseSalary;
    public BasePlusComissionEmployee(String firstName, String lastName, String socialSecurityNumber, double gs, double cr,double bs){
        super(firstName, lastName, socialSecurityNumber, gs, cr);
        this.baseSalary = bs;
    }

    @Override
    public double getPaymentAmount(){
        double cSal = (getGrossSales() * getComissionRate()) + this.baseSalary;
        return cSal;
    }

    @Override
    public void display(){
        System.out.println("First Name : "+ getFirstName());
        System.out.println("Last Name : "+ getLastName());
        System.out.println("Social Security # : "+ getSocialSecurityNumber());
        System.out.println("Gross Sales : " + getGrossSales());
        System.out.println("ComissionRate : " + getComissionRate());
        System.out.println("Salary : $" + this.getPaymentAmount());
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
