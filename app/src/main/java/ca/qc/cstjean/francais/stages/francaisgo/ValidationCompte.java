package ca.qc.cstjean.francais.stages.francaisgo;

/**
 * Classe de validation spécifique à un utilisateur.
 * Permet la validation de tous les champs d'un utilisateur.
 *
 * @author Mike Larrivée
 * @version 1.2
 * @see ca.qc.cstjean.francais.stages.francaisgo.Validation
 * @see ca.qc.cstjean.francais.stages.francaisgo.Utilisateur
 */
public class ValidationCompte {

    /**
     * Constructeur privé. La classe sera accédée uniquement dans un contexte statique.
     */
    private ValidationCompte() {}

    /**
     * Méthode privé qui fait la validation d'un texte de base.
     * Cette validation vérifie que le texte est compris dans une intervalle et qu'il n'est
     * composé que de caractères alphanumériques.
     *
     * @param p_texte le texte à vérifier.
     * @param p_min la taille minimum.
     * @param p_max la taille maximum.
     * @return vrai si le texte est valide.
     * @since 1.2
     */
    private static boolean validerStringBase(String p_texte, int p_min, int p_max) {
        // Modification v1.1 : Ajout du test estAlphaNumérique
        return Validation.saisieTexteIntervalle(p_texte, p_min, p_max) &&
                Validation.estAlphaNumérique(p_texte);
    }

    /**
     * Indique si le nom de compte d'un utilisateur est valide.
     *
     * @param p_nomCompte le nom de compte de l'utilisateur.
     * @return vrai si le nom de compte est valide.
     */
    public static boolean validerNomCompte(String p_nomCompte) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_nomCompte, 3, 16);
    }

    /**
     * Indique si le mot de passe d'un utilisateur est valide.
     *
     * @param p_motDePasse le mot de passe de l'utilisateur.
     * @return vrai si le mot de passe est valide.
     */
    public static boolean validerMotDePasse(String p_motDePasse) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_motDePasse, 8, 16);
    }

    /**
     * Indique si le nom d'un utilisateur est valide.
     *
     * @param p_nom le nom de l'utilisateur.
     * @return vrai si le nom est valide.
     */
    public static boolean validerNom(String p_nom) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_nom, 2, 16);
    }

    /**
     * Indique si le prénom d'un utilisateur est valide.
     *
     * @param p_prenom le prénom d'un utilisateur.
     * @return vrai si le prénom est valide.
     */
    public static boolean validerPrenom(String p_prenom) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_prenom, 2, 16);
    }

    /**
     * Indique si l'établissement d'origine est valide.
     *
     * @param p_etablissement l'établissement d'origine de l'utilisateur.
     * @return vrai si l'établissement d'origine est valide.
     */
    public static boolean validerEtablissementOrigine(String p_etablissement) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_etablissement, 5, 30);
    }

    /**
     * Indique si la ville de stage d'un utilisateur est valide.
     *
     * @param p_ville la ville de stage de l'utilisateur.
     * @return vrai si la ville de stage est valide.
     */
    public static boolean validerVilleStage(String p_ville) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_ville, 5, 30);
    }

    /**
     * Indique si les informations de contacts sont valides.
     *
     * @param p_rejoindre l'information de contact de l'utilisateur.
     * @return vrai si l'information de contact est valide.
     */
    public static boolean validerJoindre(String p_rejoindre) {
        return Validation.courrielValide(p_rejoindre) ||
                Validation.estUrlValide(p_rejoindre) ||
                Validation.formatTelephoneValide(p_rejoindre);
    }

    /**
     * Indique si le commentaire associé à un utilisateur est valide.
     *
     * @param p_commentaire le commentaire de l'utilisateur.
     * @return vrai si le commentaire est valide.
     */
    public static boolean validerCommentaire(String p_commentaire) {
        // Modification v1.2 : Refactoring pour du code plus réutilisable
        return validerStringBase(p_commentaire, 0, 30);
    }

    /**
     * Indique si les informations relatifs à la création d'un utilisateur sont valides.
     *
     * @param p_nomCompte le nom de compte de l'utilisateur.
     * @param p_motDePasse le mot de passe de l'utilisateur.
     * @param p_nom le nom de l'utilisateur.
     * @param p_prenom le prénom de l'utilisateur.
     * @param p_lieuStage la ville de stage de l'utilisateur.
     * @param p_villeOrigine l'établissement d'origine de l'utilisateur.
     * @param p_contact l'information de contact de l'utilisateur.
     * @param p_description le commentaire de l'utilisateur.
     * @return vrai si toutes les informations sont valides.
     */
    public static boolean validerCreationCompte(String p_nomCompte, String p_motDePasse, String p_nom,
                                                String p_prenom, String p_lieuStage, String p_villeOrigine,
                                                String p_contact, String p_description) {
        return validerNomCompte(p_nomCompte) &&
                validerMotDePasse(p_motDePasse) &&
                validerNom(p_nom) && validerPrenom(p_prenom) &&
                validerEtablissementOrigine(p_villeOrigine) &&
                validerVilleStage(p_lieuStage) &&
                validerCommentaire(p_description) &&
                validerJoindre(p_contact);
    }

    /**
     * Indique si les informations relatifs à la modification d'un utilisateur sont valides.
     *
     * @param p_lieuStage la ville de stage de l'utilisateur.
     * @param p_villeOrigine l'établissement d'origine de l'utilisateur.
     * @param p_contact l'information de contact de l'utilisateur.
     * @param p_description le commentaire de l'utilisateur.
     * @return vrai si toutes les informations sont valides.
     */
    public static boolean validerModificationCompte(String p_lieuStage, String p_villeOrigine,
                                                    String p_contact, String p_description) {
        return validerVilleStage(p_lieuStage) && validerEtablissementOrigine(p_villeOrigine) &&
                validerJoindre(p_contact) && validerCommentaire(p_description);
    }
}
