package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TransactionGroupActivity extends AppCompatActivity {
    ArrayList<Transaction> list_trans;
    ArrayList<Colaborator> list_colab;

    private static Group grp;
    public static Group getGrp() {
        return grp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_group);


        String group = MainActivity.getText();
        final TextView helloTextView = (TextView) findViewById(R.id.Balance);
        helloTextView.setText(group);

        ArrayList<Group> list_group  = MainActivity.getList_group();

        for (int k=0;k<list_group.size();k++){
            if (list_group.get(k).getName() == group){
                grp = list_group.get(k);
                list_trans = list_group.get(k).getList_transaction();
            }
        }
        final LinearLayout layout_list = (LinearLayout) findViewById(R.id.transactions);
        layout_list.removeAllViewsInLayout();

        for (int i=0;i<list_trans.size();i++){
            Button list_button = new Button(this);
            list_button.setText(list_trans.get(i).getTittle());
            layout_list.addView(list_button);

        }
        Double total=Calcul.calculEquilibre(grp);
        helloTextView.setText(total.toString());
        list_colab=grp.getColaborators();
        for (int i=0;i<list_colab.size();i++){
            Button list_button = new Button(this);
            list_button.setText(list_colab.get(i).getName().toString()+list_colab.get(i).getAmount().toString());
            layout_list.addView(list_button);

        }
        FloatingActionButton fab = findViewById(R.id.floatingActionButton4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(TransactionGroupActivity.this, com.example.projetandroid.DetailTransactionActivity.class);
                startActivity(detail);
            }
        });
       // transactions
    }
}
