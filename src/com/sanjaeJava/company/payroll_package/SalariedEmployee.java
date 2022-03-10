package com.sanjaeJava.company.payroll_package;

public class SalariedEmployee extends Employee{
    private double weeklySalary;
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber){
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = 0.0;
    }
}
