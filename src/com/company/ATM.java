package com.company;

import java.util.HashMap;

public class ATM extends Room implements CashReduce{

    private int totalBankCash;

    public ATM() {
    }

    public int userInputCash(int bankCash) {
        this.totalBankCash = bankCash;
        return totalBankCash;
    }

    @Override
    public int cashReduceMethod(int cash) {
        this.totalBankCash -= cash;
        return cash;
    }

   // public void withdrawal(int cash) {
   //     this.totalBankCash -= cash;
   // }

    public int getTotalBankCash() {
        return totalBankCash;
    }
}
