package com.example.projetandroid;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;

public class CreatingGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creating_group);
        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();*/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public OnClickListener onClickAddButton(View v){
        LinearLayout addingLayout = findViewById(R.id.addingLayout);
        EditText prevPerson = findViewById(R.id.personne);
        Button prevButton = findViewById(R.id.addButton);

        LinearLayout  hLayout = new LinearLayout(this);
        hLayout.setOrientation(LinearLayout.HORIZONTAL);

        EditText newPerson = new EditText(this);
        newPerson.setText(getResources().getString(R.string.guest_name_prompt));

        Button newButton = new Button(this);
        newButton.setText(prevButton.getText());
        newButton.setOnClickListener(onClickAddButton(v));
                /*new OnClickLister(){
            public void onClickAddButtonAssign(View v){
                onClickAddButton(v);
            }
        });*/

                return this.onClickAddButton(v);
    }

    public void onClickValidateButton(View v){

    }

    /*public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }*/
}