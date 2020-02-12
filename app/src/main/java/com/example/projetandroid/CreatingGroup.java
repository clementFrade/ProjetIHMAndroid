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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CreatingGroup extends AppCompatActivity {

    private ArrayList<String> colaborators = new ArrayList<>();

    /**
     * Création de la page à partir du fichier creating_group.xml associé.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creating_group);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Lorsqu'un click est effectué sur le bouton "Ajouter l'invité", le nom entré dans le champ à sa gauche
     * est sauvegardé dans une liste de string. Ce bouton se change alors en "Retirer l'invité", qui permet de
     * supprimer cette personne de la liste. Dans un même temps, un nouveau champ est ajouté en-dessous,
     * dans lequel on peut inscire un nouvel invité au groupe.
     * @param v
     */
    public void onClickAddButton(View v){

        /*Récupération du dernier layout de ceux contenus dans addingLayout*/
        LinearLayout addingLayout = findViewById(R.id.addingLayout);
        ViewGroup lasthLayout = (ViewGroup) addingLayout.getChildAt(addingLayout.getChildCount()-1);
        EditText prevPerson = (EditText) lasthLayout.getChildAt(0);
        Button prevButton = (Button) lasthLayout.getChildAt(1);

        /*Ajout du nouveau colaborateur à la liste des invités du groupe*/
        colaborators.add(prevPerson.getText().toString());

        /*Création d'un nouveau layout pour le nouveau champ et le nouveau bouton, aux mêmes paramètres
         * que le précédent layout*/
        LinearLayout  hLayout = new LinearLayout(this);
        hLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) lasthLayout.getLayoutParams();
        hLayout.setLayoutParams(lp);

        /*Création d'un nouveau champ, aux mêmes paramètres que le précédent champ*/
        EditText newPerson = new EditText(this);
        newPerson.setHint(getResources().getString(R.string.guest_name_prompt));
        newPerson.setWidth(prevPerson.getWidth());
        newPerson.setHeight(prevPerson.getHeight());

        /*Création d'un nouveau bouton, aux mêmes paramètres que le précédent bouton*/
        Button newButton = new Button(this);
        newButton.setText(getResources().getString(R.string.add_button_prompt));
        newButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAddButton(v);
            }
        });
        newButton.setWidth(prevButton.getWidth());
        newButton.setHeight(prevButton.getHeight());

        /*Ajout des composants du nouveau layout*/
        hLayout.addView(newPerson);
        hLayout.addView(newButton);

        /*Ajout du nouveau layout à adding layout*/
        addingLayout.addView(hLayout);

        /*Le nom de l'invité est fixe et non modifiable, et le précédent bouton devient un bouton de suppression*/
        prevPerson.setEnabled(false);
        prevButton.setText("Retirer l\'invité");
        prevButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDelButton(v);
            }
        });
    }

    /**
     * Quand un click est effectué sur un bouton "Retirer l'invité", la ligne sur laquelle se trouvaient
     * le bouton cliqué est supprimée, ainsi que le collaborateur de la liste de string.
     * @param v
     */
    public void onClickDelButton(View v){

        /*Récupération du nom du collaborateur à supprimer*/
        LinearLayout addingLayout = findViewById(R.id.addingLayout);
        LinearLayout buttonLayout = (LinearLayout) v.getParent();
        EditText colabToDel = (EditText) buttonLayout.getChildAt(0);
        String colab = colabToDel.getText().toString();

        /*Recherche du collaborateur dans la liste*/
        for(int i = 0 ; i<colaborators.size() ; i++){
            if(colaborators.get(i)==colab) colaborators.remove(i);break;
        }

        /*Suppression de la ligne à supprimer*/
        addingLayout.removeView(buttonLayout);
    }

    /**
     * Un click sur le bouton Valider envoie toutes les informations saisies vers la page d'accueil,
     * qui affichera désormais ce groupe parmi tous ceux qui auront été créés.
     * @param v
     */
    public void onClickValidateButton(View v){

        /*Récupération des différents champs de la page, ainsi que de la liste des collaborateurs du groupe*/
        TextView nameTextView = findViewById(R.id.inputName);
        String name = nameTextView.getText().toString();

        TextView desTextView = findViewById(R.id.inputDescription);
        String des = desTextView.getText().toString();

        Spinner deviseSpinner = findViewById(R.id.inputDevise);
        String devise = deviseSpinner.getSelectedItem().toString();

        ArrayList<Colaborator> list_colabo = new ArrayList<Colaborator>();
        for (int k=0;k<colaborators.size();k++){
            list_colabo.add(new Colaborator(colaborators.get(k)));
        }

        /*Transmission du Group vers le champ de MainActivity dédié à son stockage*/
        Group group = new Group(name,des,devise,list_colabo);
        MainActivity.setList_group(group);

        /*Retour vers la page d'accueil*/
        Intent MainActivity = new Intent(CreatingGroup.this, com.example.projetandroid.MainActivity.class);
        startActivity(MainActivity);
    }

}