package com.sanjaeJava.company.payroll_package;

public class BasePlusComissionEmployee extends ComissionEmployee{
    private double baseSalary;
    public BasePlusComissionEmployee(String firstName, String lastName, String socialSecurityNumber){
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = 0.0;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
