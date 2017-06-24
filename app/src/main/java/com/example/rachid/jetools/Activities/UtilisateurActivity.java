package com.example.rachid.jetools.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rachid.jetools.Builder.JeTools;
import com.example.rachid.jetools.Controllers.UtilisateurController;
import com.example.rachid.jetools.Fragments.JourneesFragment;
import com.example.rachid.jetools.Listeners.UtilisateurModelChangeListener;
import com.example.rachid.jetools.Models.UtilisateurModel;
import com.example.rachid.jetools.R;

public class UtilisateurActivity extends AppCompatActivity implements UtilisateurModelChangeListener {

    UtilisateurController utilisateurController;
    UtilisateurModel utilisateurModel;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilisateur);
        utilisateurController = ((JeTools) getApplication()).getUtilisateurController();
        utilisateurModel = ((JeTools) getApplication()).getUtilisateurModel();
        utilisateurModel.addUtilisateurModelChangeListener(this);
    }

    public void connecterUtilisateur(View view){
        EditText mPseudo = (EditText) findViewById(R.id.pseudoVal);
        EditText mMdp = (EditText) findViewById(R.id.mdpVal);
        utilisateurController.connecterUtilisateur(mPseudo.getText()+"", mMdp.getText()+"");
    }

    @Override
    public void onUtilisateurModelChange() {
        Toast.makeText(this, this.utilisateurModel.getNom()+" "+this.utilisateurModel.getPrenom(),
                Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, JourneesActivity.class);
        startActivity(intent);
    }
}
