package com.example.projetandroid;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;

import java.util.ArrayList;

public class CreatingGroup extends AppCompatActivity {

    private Group groupe;
    private ArrayList<String> colaborators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creating_group);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void onClickAddButton(View v){

        LinearLayout addingLayout = findViewById(R.id.addingLayout);
        ViewGroup lasthLayout = (ViewGroup) addingLayout.getChildAt(addingLayout.getChildCount()-1);
        EditText prevPerson = (EditText) lasthLayout.getChildAt(0);
        Button prevButton = (Button) lasthLayout.getChildAt(1);

        colaborators.add(prevPerson.getText().toString());

        LinearLayout  hLayout = new LinearLayout(this);
        hLayout.setOrientation(LinearLayout.HORIZONTAL);

        EditText newPerson = new EditText(this);
        newPerson.setText(getResources().getString(R.string.guest_name_prompt));

        Button newButton = new Button(this);
        newButton.setText(prevButton.getText());
        newButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddButton(v);
            }
        });

        hLayout.addView(newPerson);
        hLayout.addView(newButton);

        addingLayout.addView(hLayout);

        prevPerson.setEnabled(false);
        prevButton.setText("Retirer l\'invité");
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