package ca.qc.cstjean.francais.stages.francaisgo;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

/**
 * Description : Définition d'un utilisateur de l'application
 *               dans notre cas, l'utilisateur est un stagiaire français.
 * Auteur(s) : Alexis Richer
 * Date de création : 30 novembre 2016
 * Date de dernière modification : 30 novembre 2016
 */
public class Utilisateur {

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
    public Utilisateur(UUID p_id, LatLng p_position, String p_nom, String p_prenom,
                       String p_lieuStage, String p_villeOrigine, String p_contact,
                       String p_description) {
        ID = p_id;
        Position = p_position;
        Nom = p_nom;
        Prenom = p_prenom;
        LieuDeStage = p_lieuStage;
        VilleOrigine = p_villeOrigine;
        Contact = p_contact;
        Description = p_description;
    }
    private UUID ID;
    private LatLng Position;
    private String Nom;
    private String Prenom;
    private String LieuDeStage;
    private String VilleOrigine;
    private String Contact;
    private String Description;

    /**
     * Accesseur de l'ID, (peut n'avoir aucune valeur... attention)
     * @return UUID de l'utilisateur
     */
    public UUID getID() {
        return ID;
    }

    /**
     * Accesseur de la postition, (peut n'avoir aucune valeur... attention)
     * @return position de l'utilisateur (LatLng)
     */
    public LatLng getPosition() {
        return Position;
    }

    /**
     * Accesseur du nom, (peut n'avoir aucune valeur... attention)
     * @return nom de l'utilisateur
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Change la position de l'utilisateur avec la position passé en paramètre
     * @param p_pos la position de l'utilisateur
     */
    public void setPosition(LatLng p_pos) {
        Position = p_pos;
    }

    /**
     * Accesseur du prenom, (peut n'avoir aucune valeur... attention)
     * @return nom de l'utilisateur
     */
    public String getPrenom() {
        return Prenom;
    }

    /**
     * Accesseur du lieu de stage, (peut n'avoir aucune valeur... attention)
     * @return lieu de stage de l'utilisateur
     */
    public String getLieuDeStage() {
        return LieuDeStage;
    }

    /**
     * Accesseur de la ville d'origine, (peut n'avoir aucune valeur... attention)
     * @return la ville d'origine de l'utilisateur
     */
    public String getVilleOrigine() {
        return VilleOrigine;
    }

    /**
     * Accesseur du champ contact, (peut n'avoir aucune valeur... attention)
     * @return le contact de l'utilisateur
     */
    public String getContact() {
        return Contact;
    }

    /**
     * Accesseur de la description, (peut n'avoir aucune valeur... attention)
     * @return description de l'utilisateur
     */
    public String getDescription() {
        return Description;
    }
}
