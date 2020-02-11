package com.example.projetandroid;

import java.util.ArrayList;

public class Group {

    private String name;
    private String user;
    private ArrayList<String> colaborators;
    private ArrayList<Transaction> list_transaction;

    public Group(String name, String user, ArrayList<String> colaborators) {
        this.name = name;
        this.user = user;
        this.colaborators = colaborators;
        this.list_transaction = new ArrayList<Transaction>();
    }
}
