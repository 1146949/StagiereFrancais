package ca.qc.cstjean.francais.stages.francaisgo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

/**
 * Created by Antoine on 2016-12-07.
 */

public class InscriptionActivity extends Activity {
    private EditText m_textBoxNomCompte;
    private EditText m_textBoxMotDePasse;
    private EditText m_textBoxNom;
    private EditText m_textBoxPrenom;
    private EditText m_textBoxEtablissementOrigine;
    private EditText m_textBoxNomVilleDeStage;
    private EditText m_textBoxRejoindre;
    private EditText m_textBoxMultiligneComentaire;

    private Button m_boutonConfirmer;
    private Button m_boutonAnnuler;

    private String m_nomCompte;
    private String m_motDePasse;
    private String m_nom;
    private String m_prenom;
    private String m_etablissementOrigine;
    private String m_nomVilleStage;
    private String m_rejoindre;
    private String m_comentaire;

    private SingletonBD m_singletonBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_inscription);

        m_singletonBD = SingletonBD.getInstance(getApplicationContext());

        affecterControl();

        creerListenerTextBoxNomCompte();
        creerListenerTextBoxMotDePasse();
        creerListenerTextBoxNom();
        creerListenerTextBoxPrenom();
        creerListenerTextBoxEtablissementOrigine();
        creerListenerTextBoxNomVilleDeStage();
        creerListenerTextBoxRejoindre();
        creerListenerTextBoxMultiligneComentaire();
        creerListenerBoutonConfirmer();
        creerListenerBoutonAnnuler();
    }

    /**
     * Affecte les controles pour qu'ils soient utillisable dans l'application et être utiliser dans
     * d'autres fonctions.
     */
    private void affecterControl() {
        m_textBoxNomCompte = (EditText) findViewById(R.id.editText_nomUtilisateur);
        m_textBoxMotDePasse = (EditText) findViewById(R.id.editText_motPasse);
        m_textBoxNom = (EditText) findViewById(R.id.editText_nom);
        m_textBoxPrenom = (EditText) findViewById(R.id.editText_prenom);
        m_textBoxEtablissementOrigine = (EditText) findViewById(R.id.editText_etablissementOrigine);
        m_textBoxNomVilleDeStage = (EditText) findViewById(R.id.editText_endroitStage);
        m_textBoxRejoindre = (EditText) findViewById(R.id.editText_joindre);
        m_textBoxMultiligneComentaire = (EditText) findViewById(R.id.editText_comentaire);
        m_boutonConfirmer = (Button) findViewById(R.id.button_Confimer);
        m_boutonAnnuler = (Button) findViewById(R.id.button_annuler);
    }

    // création des listeners *****************************************************************
    private void creerListenerTextBoxNomCompte() {
        m_textBoxNomCompte.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_nomCompte = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxMotDePasse() {
        m_textBoxMotDePasse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_motDePasse = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxNom() {
        m_textBoxNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_nom = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxPrenom() {
        m_textBoxPrenom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_prenom = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxEtablissementOrigine() {
        m_textBoxEtablissementOrigine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_etablissementOrigine = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxNomVilleDeStage() {
        m_textBoxNomVilleDeStage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_nomVilleStage = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxRejoindre() {
        m_textBoxRejoindre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_rejoindre = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void creerListenerTextBoxMultiligneComentaire() {
        m_textBoxMultiligneComentaire.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_comentaire = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /**
     * Creer un listener pour l'ajout d'un nouvel utilisateur dans la bd
     */
    private void creerListenerBoutonConfirmer() {
        m_boutonConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validerChamps()) {
                    Utilisateur newUser = new Utilisateur(UUID.randomUUID(), new LatLng(15, 15), m_nomCompte,
                            Hashage.HasherPasswordMD5(m_motDePasse), m_nom,
                            m_prenom, m_nomVilleStage, m_etablissementOrigine,
                            m_rejoindre, m_comentaire);

                    // Pour pouvoir passer l'utilisateur la fonction est longue et n'a rien de
                    // différent ou de nouveau

                    m_singletonBD.addUtilisateur(newUser);
                    Toast.makeText(InscriptionActivity.this, R.string.utilisateur_valide, Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(InscriptionActivity.this, R.string.champs_invalide, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void creerListenerBoutonAnnuler() {
        m_boutonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * @return La validité des champs selon les critères d'entrés
     */
    private boolean validerChamps() {

        return ValidationCompte.validerCreationCompte(m_nomCompte, m_motDePasse, m_nom, m_prenom,
                m_nomVilleStage, m_etablissementOrigine, m_rejoindre, m_comentaire);
    }
}
