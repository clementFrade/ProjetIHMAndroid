package com.example.projetandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetandroid.ui.login.LoginActivity;

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
        newButton.setText(getResources().getString(R.string.add_button_prompt));
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
        prevButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDelButton(v);
            }
        });
    }

    public void onClickDelButton(View v){

        LinearLayout addingLayout = findViewById(R.id.addingLayout);
        LinearLayout buttonLayout = (LinearLayout) v.getParent();
        EditText colabToDel = (EditText) buttonLayout.getChildAt(0);
        String colab = colabToDel.getText().toString();
        for(int i = 0 ; i<colaborators.size() ; i++){
            if(colaborators.get(i)==colab) colaborators.remove(i);break;
        }
        addingLayout.removeView(buttonLayout);
    }

    public void onClickValidateButton(View v){
        final TextView nameTextView = (TextView) findViewById(R.id.inputName);
        String name = nameTextView.getText().toString();
        ArrayList<Colaborator> list_colabo = new ArrayList<Colaborator>();
        for (int k=0;k<colaborators.size();k++){
            list_colabo.add(new Colaborator(colaborators.get(k)));
        }

        final TextView desTextView = (TextView) findViewById(R.id.inputDescription);
        String des = desTextView.getText().toString();

        final TextView deviseTextView = (TextView) findViewById(R.id.inputName);
        String devise = deviseTextView.getText().toString();

        Group group = new Group(name,des,devise,list_colabo);
        MainActivity.setList_group(group);
        Intent MainActivity = new Intent(CreatingGroup.this, com.example.projetandroid.MainActivity.class);
        startActivity(MainActivity);
    }

    /*public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }*/
}