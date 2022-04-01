package com.sanjaeJava.company.payroll_package;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice implements Payable{
    protected String customerName;
    protected String partNumber;
    protected String partDescription;
    protected int quantity;
    protected double unitCost;
    protected static int nxtInvoiceNumber = getNxtInvoiceNumber();

    public Invoice(String partNumber, String partDescription, int quantity, double unitCost) {
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        this.quantity = quantity;
        this.unitCost = unitCost;

    }
    public Invoice(){}

    public static int getNxtInvoiceNumber(){
        int invoiceNumber = nxtInvoiceNumber;
            nxtInvoiceNumber++;
        return invoiceNumber;
    }

    @Override
    public void display(){
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date : " + dateFormatter.format(date));
        System.out.println(nxtInvoiceNumber);
        System.out.println("Customer Name : " + this.customerName);
        System.out.println("Part Number : "+ this.partNumber);
        System.out.println("Part Description : "+ this.partDescription);
        System.out.println("Quantity # : "+ this.quantity);
        System.out.println("Unit Cost $ : "+ this.unitCost);
        System.out.println("Total : $" + getPaymentAmount());

    }

    @Override
    public void getInfo() {
        Scanner info = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date : " + dateFormatter.format(date));
        System.out.println("Customer Name : ");
        this.customerName = info.nextLine();
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

        return unitCost * quantity;
    }

    @Override
    public void payAdvice(){
        Date date = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat invoiceBalanceFormat = new DecimalFormat("0.00");
        try(BufferedWriter createPayStub = new BufferedWriter(new FileWriter("Invoice.txt", true))){
            createPayStub.write("\n\n\r===========================================================================================\n\r" +
                    "Date : " + dateFormatter.format(date) + "\t\t\tInvoice # : " + nxtInvoiceNumber + "\n\rPart Number : "+ this.partNumber + "\n\rPart Description : "+ this.partDescription +
                    "\n\rQuantity # : " + this.quantity + "\n\rUnit Cost $ : " + invoiceBalanceFormat.format(this.unitCost)
                    + "\n\rInvoice Balance : $ " + invoiceBalanceFormat.format(getPaymentAmount()));
            System.out.println("Invoice Created successfully\n\n\r");
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
