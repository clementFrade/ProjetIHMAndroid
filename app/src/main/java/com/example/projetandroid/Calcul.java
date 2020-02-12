package com.example.projetandroid;

import java.util.ArrayList;

public class Calcul {
    public Double calculEquilibre(Group gr) {
        Double totalAmount = 0.0;
        for (Transaction t : gr.getList_transaction()) {
            Colaborator user = t.getPayBy();
            Double amount = t.getAmount();
            totalAmount += t.getAmount();
            ArrayList<Colaborator> payed = t.getPayFor();
            for (Colaborator users : gr.getColaborators()) {
                if (payed.contains(users.getName())) {
                    users.DecreaseAmount(amount / payed.size());
                }
                if (users.getName() == user.getName()) {
                    users.IncreaseAmount(amount);
                }
            }
        }
        return totalAmount;
    }
}
