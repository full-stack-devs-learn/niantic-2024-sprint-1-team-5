package com.niantic.models;

import jdk.jfr.Category;

import java.time.LocalDate;
import java.util.Date;

public class Transaction
{
    private int transaction_id;
    private int owner_id;
    private int budget_id;
    private int vendor_id;
    private int subcategory_id;
    private double amount;
    private LocalDate date;
    private String note;

    public Transaction() {

    }
    public Transaction(int transaction_id, int owner_id, int budget_id, int vendor_id, int subcategory_id, double amount, LocalDate date, String note)
    {
        this.transaction_id = transaction_id;
        this.owner_id = owner_id;
        this.budget_id = budget_id; //NULL
        this.vendor_id = vendor_id;
        this.subcategory_id = subcategory_id;
        this.amount = amount;
        this.date = date;
        this.note = note; //NULL
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getBudget_id() {
        return budget_id;
    }

    public void setBudget_id(int budget_id) {
        this.budget_id = budget_id;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public int getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(int subcategory_id) {
        this.subcategory_id = subcategory_id;
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
                "transaction_id=" + transaction_id +
                ", owner_id=" + owner_id +
                ", budget_id=" + budget_id +
                ", vendor_id=" + vendor_id +
                ", subcategory_id=" + subcategory_id +
                ", amount=" + amount +
                ", date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}
