package ca.qc.cstjean.francais.stages.francaisgo;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

/**
 * Description : Définition d'un utilisateur de l'application
 *               dans notre cas, l'utilisateur est un stagiaire français.
 * Auteur(s) : Alexis Richer et Mike Larrivée
 * Date de création : 30 novembre 2016
 * Date de dernière modification : 30 novembre 2016
 */
public class Utilisateur {

    private UUID ID;
    private LatLng Position;
    private String NomCompte;
    private String MotDePasse;
    private String Nom;
    private String Prenom;
    private String LieuDeStage;
    private String VilleOrigine;
    private String Contact;
    private String Description;

    /***
     * Creer un utilisateur avec un UUID aleatoire
     * @param p_id L'identifiant de l'utilisateur
     * @param p_position Sa position sur la map
     * @param p_nom Son nom
     * @param p_prenom Son prénom
     * @param p_lieuStage Son lieu de stage
     * @param p_villeOrigine Sa ville d'origine
     * @param p_contact Peut-être : un téléphone, un lien facebook, twitter, snapchap etc...
     * @param p_description Une description (champ facultatif)
     */
    public Utilisateur(UUID p_id, LatLng p_position, String p_nomCompte, String p_motDePasse,
                       String p_nom, String p_prenom, String p_lieuStage, String p_villeOrigine,
                       String p_contact, String p_description) {
        ID = p_id;
        Position = p_position;
        NomCompte = p_nomCompte;
        MotDePasse = p_motDePasse;
        Nom = p_nom;
        Prenom = p_prenom;
        LieuDeStage = p_lieuStage;
        VilleOrigine = p_villeOrigine;
        Contact = p_contact;
        Description = p_description;
    }

    /**
     * Accesseur de l'ID
     * @return UUID de l'utilisateur
     */
    public UUID getID() {
        return ID;
    }

    /**
     * Accesseur de la postition
     * @return position de l'utilisateur (LatLng)
     */
    public LatLng getPosition() {
        return Position;
    }

    /**
     * Accesseur du nom de compte
     * @return nom de compte de l'utilisateur
     */
    public String getNomCompte() { return NomCompte; }

    /**
     * Accesseur du mot de passe
     * @return le mot de passe de l'utilisateur
     */
    public String getMotDePasse() {return MotDePasse; }

    /**
     * Accesseur du nom
     * @return nom de l'utilisateur
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Accesseur du prenom
     * @return nom de l'utilisateur
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * Accesseur du lieu de stage
     * @return lieu de stage de l'utilisateur
     */
    public String getLieuDeStage() {
        return LieuDeStage;
    }

    /**
     * Accesseur de la ville d'origine
     * @return la ville d'origine de l'utilisateur
     */
    public String getVilleOrigine() {
        return VilleOrigine;
    }

    /**
     * Accesseur du champ contact
     * @return le contact de l'utilisateur
     */
    public String getContact() {
        return Contact;
    }

    /**
     * Accesseur de la description
     * @return description de l'utilisateur
     */
    public String getDescription() {
        return Description;
    }
}
