package com.example.projetandroid;

import java.util.ArrayList;

public class Calcul {
    public static Double calculEquilibre(Group gr) {
        Double totalAmount = 0.0;
        for (Transaction t : gr.getList_transaction()) {
            Colaborator user = t.getPayBy();
            Double amount = t.getAmount();
            totalAmount += t.getAmount();
            ArrayList<Colaborator> payed = t.getPayFor();
            for (Colaborator users : gr.getColaborators()) {
                for (Colaborator p:payed
                     ) {
                    if (p.getName()==users.getName()) {
                        users.DecreaseAmount(amount / (payed.size()-1));
                    }
                }
                if (users.getName() == user.getName()) {
                    users.IncreaseAmount(amount+amount/(payed.size()-1));
                }
            }
        }
        return totalAmount;
    }
}
