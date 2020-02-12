package com.example.projetandroid;

import java.util.ArrayList;

public class Group {

    private String name;
    private String user;
    private ArrayList<Colaborator> colaborators;
    private ArrayList<Transaction> list_transaction;
    private String devise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public ArrayList<Colaborator> getColaborators() {
        return colaborators;
    }

    public void setColaborators(ArrayList<Colaborator> colaborators) {
        this.colaborators = colaborators;
    }

    public ArrayList<Transaction> getList_transaction() {
        return list_transaction;
    }

    public void setList_transaction(ArrayList<Transaction> list_transaction) {
        this.list_transaction = list_transaction;
    }

    public Group(String name, String user,String devise, ArrayList<Colaborator> colaborators) {
        this.name = name;
        this.user = user;
        this.devise=devise;
        this.colaborators = colaborators;
        this.list_transaction = new ArrayList<Transaction>();
    }

    public Group(String name, String user,String devise, ArrayList<Colaborator> colaborators, ArrayList<Transaction> list_transaction) {
        this.name = name;
        this.user = user;
        this.devise=devise;
        this.colaborators = colaborators;
        this.list_transaction = list_transaction;
    }
}
