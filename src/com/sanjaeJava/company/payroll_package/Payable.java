package com.sanjaeJava.company.payroll_package;

public interface Payable {
    double getPaymentAmount();
    void payAdvice();
    void display();//Added for ease of displaying when testing data
    void getInfo();

}