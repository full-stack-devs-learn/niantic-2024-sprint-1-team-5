package com.niantic.models;

import java.time.LocalDate;

public class Transaction
{
    private int transactionId;
    private int ownerId;
    private int budgetId;
    private int vendorId;
    private int subcategoryId;
    private double amount;
    private LocalDate date;
    private String note;

    public Transaction() {

    }
    public Transaction(int transaction_id, int owner_id, int budget_id, int vendor_id, int subcategory_id, double amount, LocalDate date, String note)
    {
        this.transactionId = transaction_id;
        this.ownerId = owner_id;
        this.budgetId = budget_id; //NULL
        this.vendorId = vendor_id;
        this.subcategoryId = subcategory_id;
        this.amount = amount;
        this.date = date;
        this.note = note; //NULL
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", ownerId=" + ownerId +
                ", budgetId=" + budgetId +
                ", vendorId=" + vendorId +
                ", subcategoryId=" + subcategoryId +
                ", amount=" + amount +
                ", date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}
