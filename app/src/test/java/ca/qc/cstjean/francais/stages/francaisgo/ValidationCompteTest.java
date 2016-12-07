package ca.qc.cstjean.francais.stages.francaisgo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test pour la classe ValidationCompte
 * Chacune de ses méthodes sont testés vigoureusement.
 * Tous les tests sont effectués avec junit 4.
 *
 * @author Mike Larrivee
 * @version 1.0
 * @see ValidationCompte
 */
public class ValidationCompteTest {
    /**
     * Méthode de test pour validerNomCompte
     */
    @Test
    public void testValiderNomCompte() {
        // Les nom de comptes invalides.
        final String nomCompteCaractèreSpécial = "dude1900:";
        final String nomCompteTropPetit = "il";
        final String nomCompteTropGrand = "trucMachinQuiFaitPlusDe16";
        // Un nom de compte valide.
        final String nomCompteValide = "UnCompteBidon19";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerNomCompte(nomCompteCaractèreSpécial));
        assertFalse(ValidationCompte.validerNomCompte(nomCompteTropPetit));
        assertFalse(ValidationCompte.validerNomCompte(nomCompteTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerNomCompte(nomCompteValide));
    }

    /**
     * Méthode de test pour validerMotDePasse
     */
    @Test
    public void testValiderMotDePasse() {
        // Les mot de passe invalides.
        final String motPasseCaratèreSpécial = "^superMotPasse^";
        final String motPasseTropPetit = "1234567";
        final String motPasseTropGrand = "CestQuoiCeMotDePasseDeFou";
        // Un mot de passe valide.
        final String motPasseValide = "SuperPassword12";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerMotDePasse(motPasseCaratèreSpécial));
        assertFalse(ValidationCompte.validerMotDePasse(motPasseTropPetit));
        assertFalse(ValidationCompte.validerMotDePasse(motPasseTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerMotDePasse(motPasseValide));
    }

    /**
     * Méthode de test pour validerNom
     */
    @Test
    public void testValiderNom() {
        // Les nom invalides.
        final String nomCaratèreSpécial = "^superNom^";
        final String nomTropPetit = "1";
        final String nomTropGrand = "CestQuoiCeNomDeFou";
        // Un nom valide.
        final String nomValide = "SuperNom12";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerNom(nomCaratèreSpécial));
        assertFalse(ValidationCompte.validerNom(nomTropPetit));
        assertFalse(ValidationCompte.validerNom(nomTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerNom(nomValide));
    }

    /**
     * Méthode de test pour validerPrenom
     */
    @Test
    public void testValiderPrenom() {
        // Les prénoms invalides.
        final String prénomCaratèreSpécial = "^superprénom^";
        final String prénomTropPetit = "1";
        final String prénomTropGrand = "CestQuoiCeprénomDeFou";
        // Un prénom valide.
        final String prénomValide = "Superprénom12";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerPrenom(prénomCaratèreSpécial));
        assertFalse(ValidationCompte.validerPrenom(prénomTropPetit));
        assertFalse(ValidationCompte.validerPrenom(prénomTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerPrenom(prénomValide));
    }

    /**
     * Méthode de test pour validerEtablissementOrigine
     */
    @Test
    public void testValiderEtablissementOrigine() {
        // Les établissement d'origine invalides.
        final String etabCaratèreSpécial = "^superÉtab^";
        final String etabTropPetit = "1234";
        final String etabTropGrand = "CestQuoiCeÉtabDeFouQuiFaitPlusDe30Caractères";
        // Un établissement d'origine valide.
        final String etabValide = "SuperÉtab12";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerEtablissementOrigine(etabCaratèreSpécial));
        assertFalse(ValidationCompte.validerEtablissementOrigine(etabTropPetit));
        assertFalse(ValidationCompte.validerEtablissementOrigine(etabTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerEtablissementOrigine(etabValide));
    }

    /**
     * Méthode de test pour validerVilleStage
     */
    @Test
    public void testValiderVilleStage() {
        // Les villes de stage invalides.
        final String villeCaratèreSpécial = "^superVille^";
        final String villeTropPetit = "1234";
        final String villeTropGrand = "CestQuoiCeVilleDeFouQuiFaitPlusDe30Caractères";
        // Une ville de stage valide.
        final String villeValide = "SuperVille12";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerVilleStage(villeCaratèreSpécial));
        assertFalse(ValidationCompte.validerVilleStage(villeTropPetit));
        assertFalse(ValidationCompte.validerVilleStage(villeTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerVilleStage(villeValide));
    }

    /**
     * Méthode de test pour validerJoindre
     */
    @Test
    public void testValiderJoindre() {
        // Une information de contact invalide.
        final String joindreInvalide = "duNimporteQuoi";
        // Les informations de contact valides.
        final String joindreUrl = "unurl.tres.special";
        final String joindreCourriel = "uncourriel@etrange.org";
        final String joindreTelephone = "450-293-2934";

        // La méthode doit retourner false
        assertFalse(ValidationCompte.validerJoindre(joindreInvalide));

        // Les méthodes doivent retourner true
        assertTrue(ValidationCompte.validerJoindre(joindreUrl));
        assertTrue(ValidationCompte.validerJoindre(joindreCourriel));
        assertTrue(ValidationCompte.validerJoindre(joindreTelephone));
    }

    /**
     * Méthode de test pour validerCommentaire
     */
    @Test
    public void testValiderCommentaire() {
        // Les commentaires invalides.
        final String commentaireCaratèreSpécial = "^superCommentaire^";
        final String commentaireTropGrand = "CestQuoiCeCommentaireDeFouQuiFaitPlusDe30Caractères";
        // Un commentaire valide.
        final String commentaireValide = "SuperCommentaire12";

        // Les méthodes doivent retourner false
        assertFalse(ValidationCompte.validerCommentaire(commentaireCaratèreSpécial));
        assertFalse(ValidationCompte.validerCommentaire(commentaireTropGrand));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerCommentaire(commentaireValide));
    }

    /**
     * Méthode de test pour validerCreationCompte
     */
    @Test
    public void testValiderCreationCompte() {
        // Les informations d'un utilisateur invalide.
        final String nomCompteInvalide = "dude1900:";
        final String motPasseInvalide = "^superPassword^";
        final String nomInvalide = "il";
        final String prenomInvalide = "tu";
        final String lieuStageInvalide = "``^¸^trucmachin";
        final String villeOrigineInvalide = "¨¨¨``::`^¨^ville";
        final String contactInvalide = "truc@jdfh";
        final String descriptionInvalide = "```<;<;;¸^^¸^dcjdf";

        // Les informations d'un utilisateur valide.
        final String nomCompteValide = "dude101";
        final String motPasseValide = "superPassword";
        final String nomValide = "ilest";
        final String prenomValide = "bon";
        final String lieuStageValide = "trucmachin";
        final String villeOrigineValide = "ville";
        final String contactValide = "truc@jdfh.com";
        final String descriptionValide = "une description x";

        // La méthode doit retourner false
        assertFalse(ValidationCompte.validerCreationCompte(nomCompteInvalide, motPasseInvalide,
                nomInvalide, prenomInvalide, lieuStageInvalide, villeOrigineInvalide,
                contactInvalide, descriptionInvalide));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerCreationCompte(nomCompteValide, motPasseValide,
                nomValide, prenomValide, lieuStageValide, villeOrigineValide,
                contactValide, descriptionValide));
    }

    /**
     * Méthode de test pour validerModificationCompte
     */
    @Test
    public void testValiderModificationCompte() {
        // Les informations de modifications invalides.
        final String lieuStageInvalide = "``^¸^trucmachin";
        final String villeOrigineInvalide = "¨¨¨``::`^¨^ville";
        final String contactInvalide = "truc@jdfh";
        final String descriptionInvalide = "```<;<;;¸^^¸^dcjdf";

        // Les informations de modifications valides.
        final String lieuStageValide = "trucmachin";
        final String villeOrigineValide = "ville";
        final String contactValide = "truc@jdfh.com";
        final String descriptionValide = "une description x";

        // La méthode doit retourner false
        assertFalse(ValidationCompte.validerModificationCompte(lieuStageInvalide, villeOrigineInvalide,
                contactInvalide, descriptionInvalide));

        // La méthode doit retourner true
        assertTrue(ValidationCompte.validerModificationCompte(lieuStageValide, villeOrigineValide,
                contactValide, descriptionValide));
    }
}
