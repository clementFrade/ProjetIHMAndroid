package com.example.projetandroid;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String tittle;
    private Double amount;
    private Date date;
    private String payBy;
    private ArrayList<String> payFor;

    public Transaction(String tittle, Double amount, Date date, String payBy, ArrayList<String> payFor) {
        this.tittle = tittle;
        this.amount = amount;
        this.date = date;
        this.payBy = payBy;
        this.payFor = payFor;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayBy(String payBy) {
        this.payBy = payBy;
    }

    public void setPayFor(ArrayList<String> payFor) {
        this.payFor = payFor;
    }

    public String getTittle() {
        return tittle;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getPayBy() {
        return payBy;
    }

    public ArrayList<String> getPayFor() {
        return payFor;
    }
}
