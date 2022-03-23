package com.sanjaeJava.company.payroll_package;

import org.w3c.dom.Text;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;

public interface Payable {
    double getPaymentAmount();
    void payAdvice();
    void display();//Added for ease of displaying when testing data
    void getInfo();
}