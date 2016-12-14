package ca.qc.cstjean.francais.stages.francaisgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Anthony on 2016-12-02.
 */
public class LoginActivity extends Activity {
    private Button m_boutonLogin;
    private Button m_linkInscription;
    private TextView textBoxCompte;
    private TextView textBoxMotDePasse;
    private SingletonBD singletonBD;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        singletonBD = SingletonBD.getInstance(getApplicationContext());
        AffecterControles();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Affecte les widgets a leur variable respective.
     */
    private void AffecterControles() {
        m_boutonLogin = (Button) findViewById(R.id.buttonConnexion);
        m_linkInscription = (Button) findViewById(R.id.buttonInscription);
        textBoxCompte = (TextView) findViewById(R.id.editTextUsername);
        textBoxMotDePasse = (TextView) findViewById(R.id.editTextMotDePasse);

        CreerListeners();
    }

    /**
     * Creation de tous les listeners reunis
     */
    private void CreerListeners() {
        m_boutonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickHandlerButtonConnexion();
            }
        });

        m_linkInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClickHandlerButtonInscription();
            }
        });
    }

    private void ClickHandlerButtonInscription() {
        Intent intent = new Intent(LoginActivity.this, InscriptionActivity.class);
        startActivity(intent);
    }

    /**
     * Listener pour le bouton de connexion, il va vérifier les logins des usagers
     * Appelle l'activity normale
     */
    private void ClickHandlerButtonConnexion() {
        Utilisateur util = singletonBD.getUtilisateur(textBoxCompte.getText().toString(),
                Hashage.HasherPasswordMD5(textBoxMotDePasse.getText().toString()));
        if (util != null) {
            //Création du intent vers l'activity principale
            Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
            //Pas sur si cette ligne est correcte, mais devrait passer le usercourant en extra
            intent.putExtra("UsagerCourant", util.getID());
            startActivity(intent);
        }
        //Montre à l'usager qu'il n'existe pas encore
        else {
            Toast toastTemp = Toast.makeText(LoginActivity.this, R.string.connexion_invalide,Toast.LENGTH_SHORT);
            toastTemp.show();
        }
    }

    /**
     * Va envoyer l'utilisateur à l'activity d'inscription
     *
     * @param target
     */
    private void ClickHandlerButtonInscription(View target) {
        //Intent intent = new Intent(getApplicationContext(),InscriptionActivity.class);
        //startActivity(intent);
    }
}