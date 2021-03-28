package com.example;

public class TestBankService implements BankService {

    @Override
    public void pay(String id, double amount) {
        System.out.println("Employee: " + id + " just got paid: " + amount + " kr.");
    }
}
