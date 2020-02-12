package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionGroupActivity extends AppCompatActivity {
    ArrayList<Transaction> list_trans;

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
       // transactions
    }
}
