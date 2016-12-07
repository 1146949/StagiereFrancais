package ca.qc.cstjean.francais.stages.francaisgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Anthony on 2016-12-02.
 */
public class LoginActivity extends FragmentActivity {
    private Button boutonLogin;
    private Button linkInscription;
    private TextView textBoxCompte;
    private TextView textBoxMotDePasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AffecterControles();
        CreerListeners();
    }

    /**
     * Affecte les widgets a leur variable respective.
     */
    private void AffecterControles(){
        boutonLogin = (Button) findViewById(R.id.buttonConnexion);
        linkInscription = (Button) findViewById(R.id.buttonInscription);
        textBoxCompte = (TextView) findViewById(R.id.editTextUsername);
        textBoxMotDePasse = (TextView) findViewById(R.id.editTextMotDePasse);
    }

    /**
     * Creation de tous les listeners reunis
     */
    private void CreerListeners()
    {
        //ClickHandlerButtonConnexion();
        //ClickHandlerButtonInscription();
    }

    /**
     * Listener pour le bouton de connexion, il va vérifier les logins des usagers
     * @param target
     */
    private void ClickHandlerButtonConnexion(View target) {

    }

    /**
     * Va envoyer l'utilisateur à l'activity d'inscription
     * @param target
     */
    private void ClickHandlerButtonInscription(View target){
        //Intent intent = new Intent(getApplicationContext(),InscriptionActivity.class);
        //startActivity(intent);
    }
}
