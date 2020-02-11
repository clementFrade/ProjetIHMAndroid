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

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Group> list_group = new ArrayList<Group>();
    private ArrayList<String> list_colabo = new ArrayList<String>();
    //list_colabo.add
    //list_group.add(new Group("yolo","lulu",list_colabo));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        list_colabo.add("clement");
        list_group.add(new Group("yolo","lulu",list_colabo));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String user = com.example.projetandroid.ui.login.LoginActivity.getUser();
        final TextView helloTextView = (TextView) findViewById(R.id.textView2);
        helloTextView.setText("Bienvenue " + user);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginActivity = new Intent(MainActivity.this, com.example.projetandroid.ui.login.LoginActivity.class);
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
