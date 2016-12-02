package ca.qc.cstjean.francais.stages.francaisgo.database;

/**
 * classe qui représente le schéma de la base de données, fait partie de la couche modèle du MVC
 */
public class UtilisateurDbSchema {
    /**
     * classe qui représente une table d'une base de données (relationnelle ou autre)
     */
    public static final class UtilisateurTable {
        public static final String NAME = "Utilisateur";

        /**
         * Représente les colones du tableau et leur contenu (identifiées par les String à l'intérieur)
         */
        public static final class Colonnes {
            // colonne qui identifie un objet "Element" unique, cette valeur ne peut apparaître plus d'une fois
            public static final String ID = "uuid";
            // colonne qui indique le nom d'un Element
            public static final String LATITUDE = "latitude";
            // colonne qui indique le nom d'un Element
            public static final String LONGITUDE = "longtitude";
            // colonne qui indique le nom d'un Element
            public static final String NOM_COMPTE = "nom_compte";
            // colonne qui indique le nom d'un Element
            public static final String MOT_DE_PASSE = "mot_de_passe";
            // colonne qui indique le nom d'un Element
            public static final String NOM = "nom";
            // colonne qui indique le prenom d'un Element
            public static final String PRENOM = "prenom";
            // colonne qui indique le lieu de stage d'un Element
            public static final String LIEU_STAGE = "lieu_stage";
            // colonne qui indique la ville d'origine d'un Element
            public static final String VILLE_ORIGINE = "ville_origine";
            // colonne qui indique le contact d'un Element
            public static final String CONTACT = "contact";
            // colonne qui indique la description d'un Element
            public static final String DESCRIPTION = "description";
        } //class Colonnes
    } // class ElementTable
}  // class ElementDbSchema
