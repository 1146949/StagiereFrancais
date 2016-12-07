package ca.qc.cstjean.francais.stages.francaisgo.database;

import android.database.Cursor;
import android.database.CursorWrapper;




import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

import ca.qc.cstjean.francais.stages.francaisgo.Utilisateur;
import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurDbSchema.UtilisateurTable;


/**
 * Classe d'encapsulation de Cursor, ajoute des fonctionnalités (aucune pour le moment)
 * et donne accès à des méthodes utiles au traitement du curseur
 */
public class UtilisateurCursorWrapper extends CursorWrapper {
    /**
     * Créée un "cursor wrapper"
     *
     * @param cursor le curseur à encapsuler
     */
    public UtilisateurCursorWrapper(Cursor cursor) {
        super(cursor);  // appèle le constructeur de CursorWrapper
    }


    /**
     * Acesseur d'un élément dans la base de données, celui "pointé" par le curseur
     * @return  le marqueur pointé par le curseur (Marqueur)
     */
    public Utilisateur getUtilisateur() {
        // Va chercher les informations sur les Marqueurs dans la base de données
        String uuidString = getString(getColumnIndex(UtilisateurTable.Colonnes.ID));
        double latitude = getDouble(getColumnIndex(UtilisateurTable.Colonnes.LATITUDE));
        double longitude = getDouble(getColumnIndex(UtilisateurTable.Colonnes.LONGITUDE));
		String nomCompte = getString(getColumnIndex(UtilisateurTable.Colonnes.NOM_COMPTE));
		String motDePasse = getString(getColumnIndex(UtilisateurTable.Colonnes.MOT_DE_PASSE));
        String nom = getString(getColumnIndex(UtilisateurTable.Colonnes.NOM));
        String prenom = getString(getColumnIndex(UtilisateurTable.Colonnes.PRENOM));
        String lieuStage = getString(getColumnIndex(UtilisateurTable.Colonnes.LIEU_STAGE));
        String villeOrigine = getString(getColumnIndex(UtilisateurTable.Colonnes.VILLE_ORIGINE));
        String contact = getString(getColumnIndex(UtilisateurTable.Colonnes.CONTACT));
        String description = getString(getColumnIndex(UtilisateurTable.Colonnes.DESCRIPTION));


        // recréée l'élément à partir de son ID et ajoute les valeurs qui étaient dans la base de données
        return new Utilisateur(UUID.fromString(uuidString), new LatLng(latitude, longitude), nomCompte, motDePasse, nom,
                               prenom, lieuStage, villeOrigine, contact, description );
    }
} // class ElementCursorWrapper