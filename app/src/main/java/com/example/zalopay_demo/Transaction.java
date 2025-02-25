package com.example.zalopay_demo;

public class Transaction {
    private String id;
    private String date;
    private String status;
    private double amount;

    public Transaction(String id, String date, String status, double amount) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    public String getId() { return id; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public double getAmount() { return amount; }
}
