package com.example.projetandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.ArrayList;


public class DetailTransactionActivity extends AppCompatActivity {
    private TextView mTitrePrincipal;
    private EditText mTitreTransaction;
    private EditText mMontant;
    private EditText mDate;
    private Spinner mPayeur;
    private Spinner mPaye;
    private Button mPlayButton;
    private String date;
    private String montant;
    private String titre;
    private String payeur;
    private ArrayList<String> paye;
    private ArrayList<Transaction>list_transaction;
    private ArrayList<Colaborator>liste_colaborator=new ArrayList<Colaborator>();
    private ArrayList<String> payer=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaction);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitrePrincipal = (TextView) findViewById(R.id.textViewTitre);
        mTitreTransaction = (EditText) findViewById(R.id.TextTitre);
        mMontant = (EditText) findViewById(R.id.TextMontant);
        mDate = (EditText) findViewById(R.id.editTextDate);
        mPayeur = (Spinner) findViewById(R.id.Payeur);
        mPaye = (Spinner) findViewById(R.id.Payed);
        mPlayButton = (Button) findViewById(R.id.buttonValider);
        mPlayButton.setEnabled(false);
        Spinner spin = (Spinner) findViewById(R.id.Payed);
        ArrayAdapter<String> adapter ;
        /*Colaborator Clement = new Colaborator("clement");
        Colaborator Lucas = new Colaborator("lucas");
        Colaborator Thibaud = new Colaborator("thibaud");
        liste_colaborator.add(Clement);
        liste_colaborator.add(Lucas);
        liste_colaborator.add(Thibaud);*/
       liste_colaborator = TransactionGroupActivity.getGrp().getColaborators();
        /*for (Colaborator c:liste_colaborator) {
            payer.add(c.getName());
        }*/

        for (int i=0;i<liste_colaborator.size();i++) {
            payer.add(liste_colaborator.get(i).getName());
        }

        adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,payer);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        final LinearLayout layout_list = (LinearLayout) findViewById(R.id.ForWhom);
        layout_list.removeAllViewsInLayout();
        for (int i=0;i<payer.size();i++){
            CheckBox box = new CheckBox(this);
            box.setText(payer.get(i));
            layout_list.addView(box);
        }
        mPayeur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mPaye.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mTitreTransaction.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mMontant.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }
        });
        mDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date=mDate.getText().toString();
                montant=mMontant.getText().toString();
                titre=mTitreTransaction.getText().toString();
                ArrayList<Colaborator> liste=new ArrayList<Colaborator>();
                for (String p:paye) {
                    liste.add(new Colaborator(p));
                }
                Transaction transaction =new Transaction(titre,Double.parseDouble(montant), Date.valueOf(date),new Colaborator(payeur),liste);
                list_transaction.add(transaction);
                // The user just clicked
            }
        });
    }

}
