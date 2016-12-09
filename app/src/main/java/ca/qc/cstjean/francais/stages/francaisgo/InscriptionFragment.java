package ca.qc.cstjean.francais.stages.francaisgo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import java.util.UUID;

/**
 * Created by Antoine on 2016-12-07.
 */

public class InscriptionFragment extends Fragment{
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

    private SingletonBD m_bd;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        m_bd = SingletonBD.getInstance(getContext());
    }

    public View onCreateView (LayoutInflater infalter, ViewGroup container, Bundle savedInstanceState){
        final View view = infalter.inflate(R.layout.fragment_inscription, container, false);

        affecterControl(view);

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

        return view;
    }

    /**
     * Affecte les controles pour qu'ils soient utillisable dans l'application et être utiliser dans
     * d'autres fonctions.
     *
     * @param view la vue de l'application.
     */
    private void affecterControl(View view){
        m_textBoxNomCompte = (EditText) view.findViewById(R.id.editText_nomUtilisateur);
        m_textBoxMotDePasse = (EditText) view.findViewById(R.id.editText_motPasse);
        m_textBoxNom = (EditText) view.findViewById(R.id.editText_nom);
        m_textBoxPrenom = (EditText) view.findViewById(R.id.editText_prenom);
        m_textBoxEtablissementOrigine = (EditText) view.findViewById(R.id.editText_etablissementOrigine);
        m_textBoxNomVilleDeStage = (EditText) view.findViewById(R.id.editText_endroitStage);
        m_textBoxRejoindre = (EditText) view.findViewById(R.id.editText_joindre);
        m_textBoxMultiligneComentaire = (EditText) view.findViewById(R.id.editText_comentaire);
        m_boutonConfirmer = (Button) view.findViewById(R.id.button_Confimer);
        m_boutonAnnuler = (Button) view.findViewById(R.id.button_annuler);
    }

    // création des listeners *****************************************************************
    private void creerListenerTextBoxNomCompte(){
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

    private void creerListenerTextBoxMotDePasse(){
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

    private void creerListenerTextBoxNom(){
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

    private void creerListenerTextBoxPrenom(){
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

    private void creerListenerTextBoxEtablissementOrigine(){
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

    private void creerListenerTextBoxNomVilleDeStage(){
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

    private void creerListenerTextBoxRejoindre(){
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

    private void creerListenerTextBoxMultiligneComentaire(){
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

    private void creerListenerBoutonConfirmer(){
        m_boutonConfirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validerChamps()){
                    Utilisateur newUser = new Utilisateur(UUID.randomUUID(), new LatLng(0,0), m_nomCompte,
                            m_motDePasse, m_nom, m_prenom, m_nomVilleStage, m_etablissementOrigine,
                            m_rejoindre, m_comentaire);

                    Marker marker = new Marker();
                    m_bd.addUtilisateur(marker);
                    closeFragment();
                }
                else{
                    Toast.makeText(getContext(), R.string.champs_invalide, Toast.LENGTH_LONG);
                }
            }
        });
    }

    private void creerListenerBoutonAnnuler(){
        m_boutonAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFragment();
            }
        });
    }

    /**
     * Fonction qui ferme le fragment.
     */
    private void closeFragment(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }

    /**
     *
     * @return La validité des champs selon les critères d'entrés
     */
    private boolean validerChamps(){

        return ValidationCompte.validerCreationCompte(m_nomCompte, m_motDePasse, m_nom, m_prenom,
                m_nomVilleStage, m_etablissementOrigine, m_rejoindre, m_comentaire);
    }
}
