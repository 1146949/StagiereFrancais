package ca.qc.cstjean.francais.stages.francaisgo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

/**
 * Created by Anthony on 2016-12-02.
 */
public class LoginActivity extends FragmentActivity {
    private Button boutonLogin;
    private Button linkInscription;
    private TextView textBoxCompte;
    private TextView textBoxMotDePasse;
    private SingletonBD singletonBD = SingletonBD.getInstance(getApplicationContext());
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AffecterControles();
        CreerListeners();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * Affecte les widgets a leur variable respective.
     */
    private void AffecterControles() {
        boutonLogin = (Button) findViewById(R.id.buttonConnexion);
        linkInscription = (Button) findViewById(R.id.buttonInscription);
        textBoxCompte = (TextView) findViewById(R.id.editTextUsername);
        textBoxMotDePasse = (TextView) findViewById(R.id.editTextMotDePasse);
    }

    /**
     * Creation de tous les listeners reunis
     */
    private void CreerListeners() {
        ClickHandlerButtonConnexion();
        //ClickHandlerButtonInscription();
    }

    /**
     * Listener pour le bouton de connexion, il va vérifier les logins des usagers
     * Appelle l'activity normale
     *
     *
     */
    private void ClickHandlerButtonConnexion() {
        if (singletonBD.queryTestUsername(textBoxCompte.getText().toString(), textBoxMotDePasse.getText().toString()) != null) {
            //Création du intent vers l'activity principale
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            //Pas sur si cette ligne est correcte, mais devrait passer le usercourant en extra
            intent.putExtra("UsagerCourant", singletonBD.queryTestUsername(textBoxCompte.getText().toString(), textBoxMotDePasse.getText().toString()).getUtilisateur());
            startActivity(intent);
        }
        //Montre à l'usager qu'il n'existe pas encore
        else {
            Toast toastTemp = Toast.makeText(getApplicationContext(), R.string.connexion_invalide,Toast.LENGTH_SHORT);
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
