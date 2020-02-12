package com.example.projetandroid;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String tittle;
    private Double amount;
    private String date;
    private Colaborator payBy;
    private ArrayList<Colaborator> payFor;

    public Transaction(String tittle, Double amount, String date, Colaborator payBy, ArrayList<Colaborator> payFor) {
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

    public void setDate(String date) {
        this.date = date;
    }

    public void setPayBy(Colaborator payBy) {
        this.payBy = payBy;
    }

    public void setPayFor(ArrayList<Colaborator> payFor) {
        this.payFor = payFor;
    }

    public String getTittle() {
        return tittle;
    }

    public Double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Colaborator getPayBy() {
        return payBy;
    }

    public ArrayList<Colaborator> getPayFor() {
        return payFor;
    }
}
