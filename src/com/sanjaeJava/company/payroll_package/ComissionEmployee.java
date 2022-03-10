package com.sanjaeJava.company.payroll_package;

public class ComissionEmployee extends Employee{
    private double grossSales;
    private double comissionRate;
    public ComissionEmployee(String firstName, String lastName, String socialSecurityNumber){
        super(firstName, lastName, socialSecurityNumber);
        this.comissionRate = 0.0;
        this.grossSales = 0.0;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(double comissionRate) {
        this.comissionRate = comissionRate;
    }
}
