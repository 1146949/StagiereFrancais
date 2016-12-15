package ca.qc.cstjean.francais.stages.francaisgo.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurDbSchema.UtilisateurTable.Colonnes;
import ca.qc.cstjean.francais.stages.francaisgo.database.UtilisateurDbSchema.UtilisateurTable;

/**
 * Classe qui encapsule les fonctionnalités de SQLiteOpenHelper avec nos données pour gérer la base de données
 * SQLiteOpenHelper nous donne les fonctionnalités nécessaires pour la gérer.
 */
public class UtilisateurBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1; // Version de notre base de données
    private static final String DATABASE_NAME = "Marqueur.db"; // nom de notre base de données

    /**
     * constructeur de cette classe...
     *
     * @param p_contexte doit être le contexte de l'application (Context)
     */
    public UtilisateurBaseHelper(Context p_contexte) {
        super(p_contexte, DATABASE_NAME, null, VERSION);    // appèle le constructeur parent
    }


    /**
     * Exécute une requête "create" sur la table MarqueurTable.NAME
     *
     * @param db base de donnée dans laquelle on veut travailler (SQLiteDatabase)
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + UtilisateurTable.NAME + "( " +
                "_id integer primary key autoincrement, " +
                // redondance de l'id... par contre, il est plus rapide d'opérer sur des entiers que sur des UUID
                Colonnes.ID + ", " +
                Colonnes.LATITUDE  + ", " +
                Colonnes.LONGITUDE + ", " +
                Colonnes.NOM_COMPTE + ", " +
                Colonnes.MOT_DE_PASSE + ", " +
                Colonnes.NOM + ", " +
                Colonnes.PRENOM + ", " +
                Colonnes.VILLE_STAGE + ", " +
                Colonnes.ETABLISSEMENT_ORIGINE + ", " +
                Colonnes.CONTACT + ", " +
                Colonnes.DESCRIPTION  + ")");
    }

    /**
     * Fait du traitement lorsque la base de données a une mise à jour
     *
     * @param db         base de données (SQLiteDatabase)
     * @param oldVersion numéro de la vieille version de la base de données (int)
     * @param newVersion numéro de la nouvelle version de la base de données (int)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // inutilisé pour le moment
    }
}


