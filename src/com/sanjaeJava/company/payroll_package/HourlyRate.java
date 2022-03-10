package com.sanjaeJava.company.payroll_package;

public class HourlyRate extends Employee{
    private double wage;
    private double hours;

    public HourlyRate(String firstName, String lastName, String socialSecurityNumber){
        super(firstName, lastName, socialSecurityNumber);
        this.hours = 0.0; this.wage = 0.0;
    }

    public double getWage(){
        return this.wage;
    }

    public double getHours(){
        return this.hours;
    }
}
