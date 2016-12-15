package ca.qc.cstjean.francais.stages.francaisgo;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.google.android.gms.maps.model.LatLng;
import java.util.UUID;

/**
 * Test pour la classe Utilisateur
 * Chacune de ses méthodes sont testés vigoureusement.
 * Tous les tests sont effectués avec junit 4.
 *
 * @author Mike Larrivee
 * @version 1.0
 * @see Utilisateur
 */
public class UtilisateurTest {
    /**
     * Méthode de test du constructeur et de ses accesseurs.
     */
    @Test
    public void testCreationUtilisateur() {
        // Les informations de l'utilisateur.
        final UUID id = UUID.randomUUID();
        final LatLng position = new LatLng(1, 1);
        final String nomCompte = "CompteTest";
        final String motPasse = "MotDePasseBeton";
        final String nomUtilisateur = "Utilisateur";
        final String prenomUtilisateur = "Test";
        final String lieuStage = "Saint-Jean-sur-Richelieu";
        final String villeOrigine = "Paris";
        final String contact = "www.facebook.com/DonaldTrump";
        final String description = "Pour me rejoindre vous devez passer par mon facebook";

        // Instanciation de l'utilisateur.
        Utilisateur utilisateur = new Utilisateur(id, position, nomCompte, motPasse, nomUtilisateur,
                prenomUtilisateur, lieuStage, villeOrigine, contact, description);

        // Test des accesseurs.
        assertEquals(id, utilisateur.getID());
        assertEquals(position, utilisateur.getPosition());
        assertEquals(nomCompte, utilisateur.getNomCompte());
        assertEquals(motPasse, utilisateur.getMotDePasse());
        assertEquals(nomUtilisateur, utilisateur.getNom());
        assertEquals(prenomUtilisateur, utilisateur.getPrenom());
        assertEquals(lieuStage, utilisateur.getVilleDeStage());
        assertEquals(villeOrigine, utilisateur.getEtablissementOrigine());
        assertEquals(contact, utilisateur.getContact());
        assertEquals(description, utilisateur.getDescription());
    }
}
