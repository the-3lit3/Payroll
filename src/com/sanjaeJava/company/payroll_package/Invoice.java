package com.sanjaeJava.company.payroll_package;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Invoice implements Payable{
    protected String partNumber;
    protected String partDescription;
    protected int quantity;
    protected double unitCost;

//    public Invoice(String partNumber, String partDescription, int quantity, double unitCost) {
//        this.partNumber = partNumber;
//        this.partDescription = partDescription;
//        this.quantity = quantity;
//        this.unitCost = unitCost;
//    }
    public Invoice(){}

    @Override
    public void display(){
        System.out.println("Part Number : "+ this.partNumber);
        System.out.println("Part Description : "+ this.partDescription);
        System.out.println("Quantity # : "+ this.quantity);
        System.out.println("Unit Cost $ : "+ this.unitCost);
        System.out.println("Total : $" + getPaymentAmount());

    }

    @Override
    public void getInfo() {
        Scanner info = new Scanner(System.in);
        System.out.println("Part Number : ");
        this.partNumber = info.nextLine();
        System.out.println("Part Description : ");
        this.partDescription = info.nextLine();
        System.out.println("Quantity # : " );
        this.quantity = info.nextInt();
        System.out.println("Unit Cost $ : ");
        this.unitCost = info.nextDouble();
    }

    @Override
    public double getPaymentAmount(){
        double totalCost = unitCost * quantity;
        return totalCost;
    }

    @Override
    public void payAdvice(){
        LocalDate nw = LocalDate.now();
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("Invoice.txt", true))){
            createPayStub.write("\n\n\r===========================================================================================\n\r" +
                    "Date : " + nw + "\n\rPart Number : "+ this.partNumber + "\n\rPart Description : "+ this.partDescription +
                    "\n\rQuantity # : " + this.quantity + "\n\rUnit Cost $ : " + this.unitCost
                    + "\n\rInvoice Balance : $ " + (int) getPaymentAmount());
            System.out.println("Invoice Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
