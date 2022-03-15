package com.sanjaeJava.company.payroll_package;

public class Invoice implements Payable{
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double unitCost;

    public Invoice(String partNumber, String partDescription, int quantity, double unitCost) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }
    @Override
    public void display(){
        System.out.println("Part Number : "+ this.partNumber);
        System.out.println("Part Description : "+ this.partDescription);
        System.out.println("Quantity # : "+ this.quantity);
        System.out.println("Unit Cost # : "+ this.unitCost);

    }
    @Override
    public double getPaymentAmount(){
        double totalCost = unitCost * quantity;
        return totalCost;
    }


}
