package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;

import com.example.projetandroid.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Date;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String text;

    public static String getText() {
        return text;
    }


    private static ArrayList<Group> list_group = new ArrayList<Group>();
    private ArrayList<Button> liste = new ArrayList<Button>();


    public static ArrayList<Group> getList_group() {
        return list_group;
    }

    public static void setList_group(Group group) {
        MainActivity.list_group.add(group);
    }

    public static void add(Transaction transaction, int k) {
        MainActivity.list_group.get(k).setList_transaction(transaction);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String user = com.example.projetandroid.ui.login.LoginActivity.getUser();
        final TextView helloTextView = (TextView) findViewById(R.id.textView2);
        helloTextView.setText("Bienvenue " + user);

        final LinearLayout layout_list = (LinearLayout) findViewById(R.id.layoutGroup);
        layout_list.removeAllViewsInLayout();

        for (int i=0;i<list_group.size();i++){
            Button list_button = new Button(this);
            list_button.setText(list_group.get(i).getName());
            layout_list.addView(list_button);
            liste.add(list_button);
        }
        for (final Button b : liste){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text= b.getText().toString();
                    Intent transactionSummary = new Intent(MainActivity.this, com.example.projetandroid.TransactionGroupActivity.class);
                    startActivity(transactionSummary);

                }
            });
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginActivity = new Intent(MainActivity.this, com.example.projetandroid.CreatingGroup.class);
                startActivity(LoginActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent LoginActivity = new Intent(MainActivity.this, com.example.projetandroid.ui.login.LoginActivity.class);
            startActivity(LoginActivity);
        }

        return super.onOptionsItemSelected(item);
    }
}
