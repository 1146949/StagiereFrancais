package ca.qc.cstjean.francais.stages.francaisgo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.os.RemoteException;
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

import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.internal.zzf;

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

                    // Pour pouvoir passer l'utilisateur la fonction est longue et n'a rien de
                    // différent ou de nouveau
                    Marker marker = new Marker(new zzf() {
                        @Override
                        public void remove() throws RemoteException {

                        }

                        @Override
                        public String getId() throws RemoteException {
                            return null;
                        }

                        @Override
                        public void setPosition(LatLng latLng) throws RemoteException {

                        }

                        @Override
                        public LatLng getPosition() throws RemoteException {
                            return null;
                        }

                        @Override
                        public void setTitle(String s) throws RemoteException {

                        }

                        @Override
                        public String getTitle() throws RemoteException {
                            return null;
                        }

                        @Override
                        public void setSnippet(String s) throws RemoteException {

                        }

                        @Override
                        public String getSnippet() throws RemoteException {
                            return null;
                        }

                        @Override
                        public void setDraggable(boolean b) throws RemoteException {

                        }

                        @Override
                        public boolean isDraggable() throws RemoteException {
                            return false;
                        }

                        @Override
                        public void showInfoWindow() throws RemoteException {

                        }

                        @Override
                        public void hideInfoWindow() throws RemoteException {

                        }

                        @Override
                        public boolean isInfoWindowShown() throws RemoteException {
                            return false;
                        }

                        @Override
                        public void setVisible(boolean b) throws RemoteException {

                        }

                        @Override
                        public boolean isVisible() throws RemoteException {
                            return false;
                        }

                        @Override
                        public boolean zzj(zzf zzf) throws RemoteException {
                            return false;
                        }

                        @Override
                        public int hashCodeRemote() throws RemoteException {
                            return 0;
                        }

                        @Override
                        public void zzak(zzd zzd) throws RemoteException {

                        }

                        @Override
                        public void setAnchor(float v, float v1) throws RemoteException {

                        }

                        @Override
                        public void setFlat(boolean b) throws RemoteException {

                        }

                        @Override
                        public boolean isFlat() throws RemoteException {
                            return false;
                        }

                        @Override
                        public void setRotation(float v) throws RemoteException {

                        }

                        @Override
                        public float getRotation() throws RemoteException {
                            return 0;
                        }

                        @Override
                        public void setInfoWindowAnchor(float v, float v1) throws RemoteException {

                        }

                        @Override
                        public void setAlpha(float v) throws RemoteException {

                        }

                        @Override
                        public float getAlpha() throws RemoteException {
                            return 0;
                        }

                        @Override
                        public void setZIndex(float v) throws RemoteException {

                        }

                        @Override
                        public float getZIndex() throws RemoteException {
                            return 0;
                        }

                        @Override
                        public void zzal(zzd zzd) throws RemoteException {

                        }

                        @Override
                        public zzd zzbpo() throws RemoteException {
                            return null;
                        }

                        @Override
                        public IBinder asBinder() {
                            return null;
                        }
                    });

                    marker.setPosition(newUser.getPosition());
                    marker.

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
