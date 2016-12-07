package ca.qc.cstjean.francais.stages.francaisgo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        m_map = googleMap;
        setUpMap();
    }

    public enum Mode {
        Aucun, Selection
    }

    private Mode m_mode = Mode.Aucun;
    private GoogleMap m_map;
    private Marker m_marqueurCourant; // marqueur sélectionné par l'utilisateur
    private Utilisateur m_utilisateurCourrant; // Utilisateur courrant
    private boolean m_marqueurEstModifie = false; // indique si le marqueur courant a été modifié

    // boutons de modification de l'utilisateur courrant
    private Button m_boutonModification;

    // boutons du mode Selection
    private Button m_boutonSelection;

    private SingletonBD m_singletonBD;

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
        setUpMapIfNeeded();

        GererLocations();
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
                // TODO Start le dialogue modification
            }
        });
    }

    /**
     * Créée le onClickListener du bouton Selection
     */
    private void CreerBoutonSelection() {
        m_boutonSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Start le dialogue selection
            }
        });
    }

    private void GererLocations() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission
                (this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        m_utilisateurCourrant.setPosition
                (new LatLng(location.getLatitude(), location.getLongitude()));
        m_singletonBD.updateUtilisateur(m_utilisateurCourrant);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10,
                                 (android.location.LocationListener) locationListener);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #m_map} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
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
     * <p/>
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
                //ChangerMode(Mode.Information);

                return false;
            }
        });
    }

    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            m_utilisateurCourrant.setPosition(latLng);
        }
    };


    /**
     * Remplis la GoogleMap avec les utilisateurs de la base de données
     */
    private void ChargerMap() {
        for (Utilisateur utilisateur : m_singletonBD.getListeUtilisateurs()) {
            Marker marqueurMap = m_map.addMarker(new MarkerOptions()
                    .title(utilisateur.getPrenom() + utilisateur.getNom())
                    .position(utilisateur.getPosition()));
            // cette ligne fait le lien entre la base de données et la map de Google.
            m_singletonBD.addUtilisateur(marqueurMap.getId(), utilisateur.getID());
        }
    }
}
