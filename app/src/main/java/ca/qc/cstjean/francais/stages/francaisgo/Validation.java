package ca.qc.cstjean.francais.stages.francaisgo;

/**
 * Classe de validations génériques.
 * Chaque méthode doit être accédée dans un contexte statique car il n'y a aucun constructeur disponible.
 *
 * @author Mike Larrivée
 * @version 1.3
 * @see "https://code.tutsplus.com/tutorials/8-regular-expressions-you-should-know--net-6149"
 */
class Validation {

    /**
     * Constructeur privé. La classe sera accédée uniquement dans un contexte statique.
     */
    private Validation() {}

    /**
     * Indique si une chaîne a une taille supérieure à zéro.
     * Les espaces sont enlevés.
     *
     * @param p_texte la chaîne à vérifier.
     * @return vrai si la chaîne n'est pas vide.
     */
    public static boolean stringNonVide(String p_texte) {
        return p_texte.trim().length() > 0;
    }

    /**
     * Indique si une chaîne respecte une taille minimum.
     *
     * @param p_texte la chaîne à vérifier.
     * @param p_min la taille minimale.
     * @return vrai si la chaîne est d'au moins p_min taille.
     */
    public static boolean tailleMinimum(String p_texte, int p_min) {
        return p_texte.trim().length() >= p_min;
    }

    /**
     * Indique si une chaîne respecte une taille maximale.
     *
     * @param p_texte la chaîne à vérifier.
     * @param p_max la taille maximale.
     * @return vrai si la chaîne est moins de p_max taille.
     */
    public static boolean tailleMaximum(String p_texte, int p_max) {
        return p_texte.trim().length() <= p_max;
    }

    /**
     * Indique si une chaîne est comprise entre p_min et p_max caractères.
     *
     * @param p_texte la chaîne à vérifier.
     * @param p_min la taille minimale.
     * @param p_max la taille maximale.
     * @return vrai si la chaîne est comprise dans l'intervalle p_min et p_max.
     */
    public static boolean saisieTexteIntervalle(String p_texte, int p_min, int p_max) {
        return tailleMinimum(p_texte, p_min) && tailleMaximum(p_texte, p_max);
    }

    /**
     * Indique si une chaîne contient uniquement des caractères alphanumériques.
     *
     * @param p_texte la chaîne à vérifier.
     * @return vrai si la chaîne contient uniquement des caractères alphanumériques.
     */
    public static boolean estAlphaNumérique(String p_texte) {
        // Modification v1.1 : Ajout de l'espace pour le test d'alphaNumérique
        // Modification v1.2 : Ajout de caratères accentués
        // Modification v1.3 : Correction d'un bug de l'inclusion de caractères ASCII de 65 a 122
        //                      En raison du A-z (noter le z minuscule)
        return p_texte.matches("^[a-zA-Z0-9 éÉèÈàÀïÏîÎçÇôÔ]+$");
    }

    /**
     * Indique si un numéro de téléphone est valide selon le format de l'amérique du nord et de l'europe.
     *
     * @param p_numéro la numréo sous forme de chaîne.
     * @return vrai si le numéro est dans un format valide.
     */
    public static boolean formatTelephoneValide(String p_numéro) {
        return p_numéro.matches("^([0-9]-)?([0-9]{3}-){2}[0-9]{4}$") ||
                p_numéro.matches("^([0-9]{2} ){4}[0-9]{2}$");
    }

    /**
     * Indique si une adresse courriel est valide selon le format commun simplifié.
     *
     * @param p_courriel le courriel à vérifier.
     * @return vrai si le courriel est valide.
     */
    public static boolean courrielValide(String p_courriel) {
        return p_courriel.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    /**
     * Indique si un lien url est valide selon le format commun simplifié.
     *
     * @param p_url l'url à vérifier.
     * @return vrai si l'url est dans un format valide.
     */
    public static boolean estUrlValide(String p_url) {
        return p_url.matches("^(https?:\\/\\/)?([a-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$");
    }
}
