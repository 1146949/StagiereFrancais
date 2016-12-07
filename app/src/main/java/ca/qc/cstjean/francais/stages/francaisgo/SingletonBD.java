package ca.qc.cstjean.francais.stages.francaisgo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurBaseHelper;
import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurCursorWrapper;
import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurDbSchema;
import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurDbSchema.UtilisateurTable;

import static ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurDbSchema.UtilisateurTable.Colonnes;

/**
 * Description : Classe permettant les query sur la base de donnés
 * @author Alexis Richer et Francis Prairie
 * Date de création : 7 décembre 2016
 * Date de dernière modification : 7 décembre 2016
 */
public class SingletonBD {

    private static SingletonBD m_singleton;
    private static SQLiteDatabase m_database;
    private static HashMap<String, UUID> m_listeIDUtilisateurs;

    private SingletonBD(Context p_context) {
        m_database = new UtilisateurBaseHelper(p_context.getApplicationContext()).getWritableDatabase();
    }

    public static SingletonBD getInstance(Context p_context) {
        if (m_singleton == null) {
            m_singleton = new SingletonBD(p_context);
            m_listeIDUtilisateurs = new HashMap<>();
        }

        return m_singleton;
    }

    private static ContentValues getContentValues(Marker p_marqueur, UUID p_id) {
        ContentValues values = new ContentValues();


        values.put(Colonnes.ID, p_id.toString());
        values.put(Colonnes.LATITUDE, p_marqueur.getPosition().latitude);
        values.put(Colonnes.LONGITUDE, p_marqueur.getPosition().longitude);

        UtilisateurCursorWrapper ucw = queryUtilisateur(Colonnes.ID, new String[]{p_id.toString()});
        Utilisateur user = null;

        try {
            ucw.moveToFirst();

            if (!ucw.isAfterLast()) {
                user = ucw.getUtilisateur();
            }
        } finally {
            ucw.close();
        }

        if (user == null)
            return null;

        values.put(Colonnes.NOM, user.getNom());
        values.put(Colonnes.PRENOM, user.getPrenom());
        values.put(Colonnes.LIEU_STAGE, user.getLieuDeStage());
        values.put(Colonnes.VILLE_ORIGINE, user.getVilleOrigine());
        values.put(Colonnes.CONTACT, user.getContact());
        values.put(Colonnes.DESCRIPTION, user.getDescription());

        return values;
    }

    /**
     * exécute une requête sur la base de données
     *
     * @param whereClause clause "where" pour filtrer les résultats "à l'entrée" (String)
     * @param whereArgs   arguments de la clause where, données servant à filtrer (String[])
     * @return un curseur encapsulé qui "pointe" sur la/les donnée(s) trouvées (MarqueurCursorWrapper)
     */
    private static UtilisateurCursorWrapper queryUtilisateur(String whereClause, String[] whereArgs) {
        Cursor cursor = m_database.query(
                UtilisateurTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        );

        // retourne un curseur encapsulé par MarqueurCursorWrapper (qui pointe sur le(s) élément(s) sélectionné(s))
        return new UtilisateurCursorWrapper(cursor);
    }

    /**
     * Ajoute un Marqueur dans la base de données en faisant un "insert"
     *
     * @param p_marqueur Marqueur à ajouter (Marker)
     */
    public void addUtilisateur(Marker p_marqueur) {
        // va chercher les valeurs du marqueur pour pouvoir les mettres dans la base de données
        ContentValues values = getContentValues(p_marqueur, UUID.randomUUID());

        // insère les valeurs dans la table InfoMarqueurTable.NAME
        m_database.insert(UtilisateurTable.NAME, null, values);
        assert values != null;
        m_listeIDUtilisateurs.put(p_marqueur.getId(), UUID.fromString((String) values.get(Colonnes.ID)));
    }

    /**
     * Ajoute un marqueur au HashMap (notre liste de liens entre la base de données et la GoogleMap)
     *
     * @param p_idUtilisateurHashMap identifiant du Marqueur dans la GoogleMap
     * @param p_idMarqueurBD         identifiant du Marqueur dans la BD
     */
    public void addUtilisateur(String p_idUtilisateurHashMap, UUID p_idMarqueurBD) {
        m_listeIDUtilisateurs.put(p_idUtilisateurHashMap, p_idMarqueurBD);
    }

    /**
     * met à jour un Marqueur de la base de données (ne modifie pas l'id de celui-ci)
     *
     * @param p_marqueur Marqueur modifié, son identifiant doit être le bon et exister (Marker)
     */
    public void updateUtilisateur(Marker p_marqueur) {
        // va chercher les valeurs du marqueur pour pouvoir remplacer les informations dans la base de données
        // note : on va chercher l'id du marqueur de la base de données (UUID) avec celui de la Google Map (String)
        // on se sert ensuite de ce UUID pour mettre l'information à jour dans la base de données
        ContentValues values = getContentValues(p_marqueur, m_listeIDUtilisateurs.get(p_marqueur.getId()));
        assert values != null;
        String uuidString = values.get(Colonnes.ID).toString();

        // fait une requête update dans la base de données, sur la table InfoMarqueurTable.NAME
        // et met à jour les éléments ayant le même ID (en principe, un et un seul)
        m_database.update(UtilisateurTable.NAME, values,
                Colonnes.ID + " = ?",
                new String[]{uuidString});
    }

    /**
     * Retire un utilisateur par son UUID de la BD
     *
     * @param p_idUtilisateur vrai si le retrait a fonctionné
     */
    private boolean deleteUtilisateurBD(UUID p_idUtilisateur) {
        return m_database.delete(UtilisateurTable.NAME, Colonnes.ID + "=?",
                // mettre le UUID en string empèche les erreures du genre "unrecognized token 416d"
                // (la base de données n'aime pas les tirets présents dans )
                new String[]{p_idUtilisateur.toString()}) != 0;
    }

    /**
     * Retire le utilisateur de la BD et de la liste de liens (HashMap) entre la GoogleMap et la BD
     *
     * @param p_idMarqueurGoogleMap l'id du marqueur
     * @return Vrai si le retrait de la liste de liens ET de la BD a fonctionné
     */
    public boolean deleteUtilisateur(String p_idMarqueurGoogleMap) {
        UUID idMarqueurBD = m_listeIDUtilisateurs.remove(p_idMarqueurGoogleMap);

        // si l'id est null (le premier remove n'a pas fonctionné)
        // on renvoie faux,
        // sinon on renvoie le résultat du retrait dans la BD
        return (idMarqueurBD != null && deleteUtilisateurBD(idMarqueurBD));
    }

    /**
     * Acesseur de la liste d'utilisateurs dans la base de données
     *
     * @return la liste d'utilisateurs
     */
    public List<Utilisateur> getListeMarqueurs() {
        List<Utilisateur> marqueurs = new ArrayList<>(); // créée un ArrayList (dérive de List)

        // créée un curseur Encapsulé à partir d'une requête sur toute la table (SELECT * FROM ...)
        UtilisateurCursorWrapper cursor = queryUtilisateur(null, null);

        // essaie de bouger le curseur jusqu'à ce qu'il atteigne la fin
        try {
            // déplace le curseur au début des résultats de la requête
            cursor.moveToFirst();

            // tant que le curseur n'a pas atteint la fin
            while (!cursor.isAfterLast()) {
                marqueurs.add(cursor.getUtilisateur()); // on ajoute l'utilisateur pointé par le curseur à la liste
                cursor.moveToNext(); // bouge le curseur vers le prochain utilisateur (ses informations)
            }
        }
        // si il y a une erreur quelquonque, on la laisse remonter après avoir fermé le curseur
        finally {
            cursor.close();
        }

        // si tout s'est bien déroulé, on retourne la liste d'informations sur des utilisateurs
        return marqueurs;
    }

    /**
     * Requête qui teste l'existence d'un mot de passe donné dans la base de données.
     * @param p_motDePasse mot de passe hashé
     * @return un curseur encapsulé qui "pointe" sur la/les donnée(s) trouvées
     */
    public UtilisateurCursorWrapper queryTestMdp(String p_id, String p_motDePasse) {
        Cursor cursor = m_database.rawQuery("SELECT COUNT(*) FROM " +
                UtilisateurDbSchema.UtilisateurTable.NAME + " WHERE " +
                Colonnes.MOT_DE_PASSE +
                " = " + p_motDePasse + " AND " +
                Colonnes.ID + " = " + p_id, null);

        return new UtilisateurCursorWrapper(cursor);
    }

    public UtilisateurCursorWrapper queryTestUsername(String p_username, String p_motDePasse) {
        Cursor cursor = m_database.rawQuery("SELECT COUNT(*) FROM " +
                UtilisateurDbSchema.UtilisateurTable.NAME + " WHERE " +
                Colonnes.MOT_DE_PASSE +
                " = " + p_motDePasse + " AND " +
                Colonnes.NOM_COMPTE + " = " + p_username, null);

        return new UtilisateurCursorWrapper(cursor);
    }
}
