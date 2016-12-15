package ca.qc.cstjean.francais.stages.francaisgo;

import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public enum Mode {
        Aucun, Selection
    }

    private Mode m_mode = Mode.Aucun;
    private GoogleMap m_map;
    private Marker m_marqueurCourant; // marqueur sélectionné par l'utilisateur
    private List<Marker> m_listeMarkers = new ArrayList<>(); // marqueurs
    private Utilisateur m_utilisateurCourrant; // Utilisateur courrant
    private Utilisateur m_utilisateurSelectionne; // Utilisateur selectionné

    // boutons de modification de l'utilisateur courrant
    private Button m_boutonModification;

    // boutons du mode Selection
    private Button m_boutonSelection;

    private SingletonBD m_singletonBD;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        m_map = googleMap;
        //m_singletonBD.viderBD();
        setUpMap();
    }

    /**
     * Méthode appelée lors de la création de l'activité
     *
     * @param savedInstanceState informations sauvegardées lors de la recréation de l'activité (inutile ici)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        m_singletonBD = SingletonBD.getInstance(getApplicationContext());
        UUID idUtilisateur = (UUID) getIntent().getSerializableExtra("UsagerCourant");
        m_utilisateurCourrant = m_singletonBD.getUtilisateurSelonID(idUtilisateur);
        GererLocations();

        setUpMapIfNeeded();


        AffecterControles();
        ChangerMode(Mode.Aucun);
    }

    private void ChangerMode(Mode p_mode) {
        m_mode = p_mode;
    }

    /**
     * Affecte les contrôles dans les varaibles membre, doit se faire avant d'opérer sur les boutons
     * ou sur les zones de texte
     */
    private void AffecterControles() {
        m_boutonModification = (Button) findViewById(R.id.carte_boutonModifier);
        m_boutonSelection = (Button) findViewById(R.id.carte_affichageSelection);
        CreerListenersBoutons();
    }

    private void AjouterMarker(Utilisateur p_utilisateur) {
        Marker newMarker = m_map.addMarker(new MarkerOptions().position(p_utilisateur.getPosition()));
        m_listeMarkers.add(newMarker);
        newMarker.setTitle(p_utilisateur.getPrenom() + " " + p_utilisateur.getNom());
        m_singletonBD.addUtilisateur(p_utilisateur, newMarker);
    }

    /**
     * Créée les oncLickListener sur tous les boutons...
     * fait appel aux méthodes de création des boutons respectifs
     */
    private void CreerListenersBoutons() {
        CreerBoutonModification();
        CreerBoutonSelection();
    }

    /**
     * Créée le onClickListener du bouton Modifier
     */
    private void CreerBoutonModification() {
        m_boutonModification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogueModification();
            }
        });
    }

    private void dialogueModification() {
        final Dialog dialog = new Dialog(MapsActivity.this);
        //TODO ajouter une string dans les ressources
        //dialog.setTitle(R.string.dialogue_ajouterTitre);
        dialog.setTitle("Modifier vos informations");
        dialog.setContentView(R.layout.dialog_modification_info);
        dialog.show();

        final EditText nom = (EditText) dialog.findViewById(R.id.editTextNom);
        final EditText prenom = (EditText) dialog.findViewById(R.id.editTextPrenom);
        final EditText etablissementOrigine = (EditText) dialog.findViewById(R.id.editTextEtablissementOrigine);
        final EditText villeStage = (EditText) dialog.findViewById(R.id.editTextVille);
        final EditText contact = (EditText) dialog.findViewById(R.id.editTextContact);
        final EditText description = (EditText) dialog.findViewById(R.id.editTextDescription);
        final Button btnValiderModif = (Button) dialog.findViewById(R.id.button_ok_dialog_modif);
        final Button btnAnnulerModif = (Button) dialog.findViewById(R.id.button_annuler_dialog_modif);

        nom.setText(m_utilisateurCourrant.getNom());
        prenom.setText(m_utilisateurCourrant.getPrenom());
        etablissementOrigine.setText(m_utilisateurCourrant.getEtablissementOrigine());
        villeStage.setText(m_utilisateurCourrant.getVilleDeStage());
        contact.setText(m_utilisateurCourrant.getContact());
        description.setText(m_utilisateurCourrant.getDescription());

        btnValiderModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNom = nom.getText().toString();
                String txtPrenom = prenom.getText().toString();
                String txtEtablissement = etablissementOrigine.getText().toString();
                String txtLieuStage = villeStage.getText().toString();
                String txtContact = contact.getText().toString();
                String txtDescription = description.getText().toString();
                //TODO Insérer les validations d'un utilisateur ici
                if (!ValidationCompte.validerModificationCompte(MapsActivity.this, txtNom, txtPrenom,
                        txtLieuStage, txtEtablissement, txtContact, txtDescription)) {
                    return;
                }

                // on enregistre dans deux variables le nouveau nom et description
                // et on affiche les nouvelles informations dans la zone d'information,
                // mais on ne touche pas au marqueur pour l'instant
                m_utilisateurCourrant.setNom(nom.getText().toString());
                m_utilisateurCourrant.setPrenom(prenom.getText().toString());
                m_utilisateurCourrant.setEtablissementOrigine(etablissementOrigine.getText().toString());
                m_utilisateurCourrant.setVilleDeStage(villeStage.getText().toString());
                m_utilisateurCourrant.setContact(contact.getText().toString());
                m_utilisateurCourrant.setDescription(description.getText().toString());

                m_singletonBD.updateUtilisateur(m_utilisateurCourrant);

                Marker m = getMarker(m_singletonBD.getIDMarker(m_utilisateurCourrant.getID()));

                if (m != null) {
                    m.setTitle(m_utilisateurCourrant.getPrenom() + " " + m_utilisateurCourrant.getNom());
                    m.showInfoWindow();
                    m_map.animateCamera(CameraUpdateFactory.newLatLng(m_utilisateurCourrant.getPosition()), 250, null);
                }

                // Ferme le dialogue
                dialog.cancel();

            }
        });

        btnAnnulerModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    private Marker getMarker(String p_idMarker) {
        for (Marker m : m_listeMarkers) {
            if (m.getId().equals(p_idMarker))
                return m;
        }
        return null;
    }

    /**
     * Créée le onClickListener du bouton Selection
     */
    private void CreerBoutonSelection() {
        m_boutonSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogueSelection();
            }
        });
    }

    private void dialogueSelection() {
        final Dialog dialog = new Dialog(MapsActivity.this);
        //TODO ajouter une string dans les ressources
        //dialog.setTitle(R.string.dialogue_ajouterTitre);
        dialog.setTitle("Le profil de : " +
                m_utilisateurSelectionne.getPrenom() + " " +
                m_utilisateurSelectionne.getNom());
        dialog.setContentView(R.layout.dialog_modification_info);
        dialog.show();

        final EditText nom = (EditText) dialog.findViewById(R.id.editTextNom);
        final EditText prenom = (EditText) dialog.findViewById(R.id.editTextPrenom);
        final EditText etablissementOrigine = (EditText) dialog.findViewById(R.id.editTextEtablissementOrigine);
        final EditText ville = (EditText) dialog.findViewById(R.id.editTextVille);
        final EditText contact = (EditText) dialog.findViewById(R.id.editTextContact);
        final EditText description = (EditText) dialog.findViewById(R.id.editTextDescription);
        final Button btnValiderModif = (Button) dialog.findViewById(R.id.button_ok_dialog_modif);
        final Button btnAnnulerModif = (Button) dialog.findViewById(R.id.button_annuler_dialog_modif);

        nom.setText(m_utilisateurSelectionne.getNom());
        prenom.setText(m_utilisateurSelectionne.getPrenom());
        etablissementOrigine.setText(m_utilisateurSelectionne.getEtablissementOrigine());
        ville.setText(m_utilisateurSelectionne.getVilleDeStage());
        contact.setText(m_utilisateurSelectionne.getContact());
        description.setText(m_utilisateurSelectionne.getDescription());

        nom.setEnabled(false);
        prenom.setEnabled(false);
        etablissementOrigine.setEnabled(false);
        ville.setEnabled(false);
        contact.setEnabled(false);
        description.setEnabled(false);
        btnValiderModif.setText("FERMER");

        btnAnnulerModif.setVisibility(View.GONE);

        btnValiderModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ferme le fialogue
                dialog.cancel();
            }
        });
    }

    private void GererLocations() {
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        android.location.LocationListener locationListener = new android.location.LocationListener() {
            public void onLocationChanged(Location location) {
                m_utilisateurCourrant.setPosition
                        (new LatLng(location.getLatitude(), location.getLongitude()));
                m_singletonBD.updateUtilisateur(m_utilisateurCourrant);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 5, locationListener);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #m_map} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (m_map == null) {
            // Try to obtain the map from the SupportMapFragment.
            ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMapAsync(this);
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     * <p>
     * This should only be called once and when we are sure that {@link #m_map} is not null.
     */
    private void setUpMap() {
        ChargerMap();
        CreerListenerMarqueur();
        m_map.getUiSettings().setZoomControlsEnabled(true);
    }

    /**
     * créée les listeners sur les marqueurs de la GoogleMap
     */
    private void CreerListenerMarqueur() {
        m_map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                m_marqueurCourant = marker;
                m_boutonSelection.setVisibility(View.VISIBLE);
                m_utilisateurSelectionne = m_singletonBD.chercherUtilisateurSelonID(marker.getId());
                //ChangerMode(Mode.Information);

                return false;
            }
        });
    }

    /**
     * Remplis la GoogleMap avec les utilisateurs de la base de données
     */
    private void ChargerMap() {
        for (Utilisateur utilisateur : m_singletonBD.getListeUtilisateurs()) {
            Marker marqueurMap = m_map.addMarker(new MarkerOptions()
                    .title(utilisateur.getPrenom() + " " + utilisateur.getNom())
                    .position(utilisateur.getPosition()));
            m_listeMarkers.add(marqueurMap);
            // cette ligne fait le lien entre la base de données et la map de Google.
            m_singletonBD.addUtilisateur(marqueurMap.getId(), utilisateur.getID());
        }
    }
}
