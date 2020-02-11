package com.example.projetandroid;

public class Colaborator {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void IncreaseAmount(Double amount) {
        this.amount = this.amount + amount;
    }
    public void DecreaseAmount(Double amount) {
        this.amount = this.amount - amount;
    }

    public Colaborator(String name) {
        this.name = name;
        this.amount = 0.0;
    }

    private Double amount;
}
