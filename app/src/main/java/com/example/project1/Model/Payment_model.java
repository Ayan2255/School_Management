package com.example.project1.Model;

public class Payment_model {
    String month ="";
    int fixt_bill=00;
    int pay_bill=00;

    public Payment_model(String month, int fixt_bill, int pay_bill) {
        this.month = month;
        this.fixt_bill = fixt_bill;
        this.pay_bill = pay_bill;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getFixt_bill() {
        return fixt_bill;
    }

    public void setFixt_bill(int fixt_bill) {
        this.fixt_bill = fixt_bill;
    }

    public int getPay_bill() {
        return pay_bill;
    }

    public void setPay_bill(int pay_bill) {
        this.pay_bill = pay_bill;
    }

    public Payment_model() {}

}

