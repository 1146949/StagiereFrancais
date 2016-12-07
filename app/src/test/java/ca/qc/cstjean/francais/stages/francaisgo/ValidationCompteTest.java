package ca.qc.cstjean.francais.stages.francaisgo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ValidationCompteTest {
    @Test
    public void testValiderNomCompte() {
        final String nomCompteCaractèreSpécial = "dude1900:";
        final String nomCompteTropPetit = "il";
        final String nomCompteTropGrand = "trucMachinQuiFaitPlusDe16";
        final String nomCompteValide = "UnCompteBidon19";

        assertFalse(ValidationCompte.validerNomCompte(nomCompteCaractèreSpécial));
        assertFalse(ValidationCompte.validerNomCompte(nomCompteTropPetit));
        assertFalse(ValidationCompte.validerNomCompte(nomCompteTropGrand));

        assertTrue(ValidationCompte.validerNomCompte(nomCompteValide));
    }

    @Test
    public void testValiderMotDePasse() {
        final String motPasseCaratèreSpécial = "^superMotPasse^";
        final String motPasseTropPetit = "1234567";
        final String motPasseTropGrand = "CestQuoiCeMotDePasseDeFou";
        final String motPasseValide = "SuperPassword12";

        assertFalse(ValidationCompte.validerMotDePasse(motPasseCaratèreSpécial));
        assertFalse(ValidationCompte.validerMotDePasse(motPasseTropPetit));
        assertFalse(ValidationCompte.validerMotDePasse(motPasseTropGrand));

        assertTrue(ValidationCompte.validerMotDePasse(motPasseValide));
    }

    @Test
    public void testValiderNom() {
        final String nomCaratèreSpécial = "^superNom^";
        final String nomTropPetit = "1";
        final String nomTropGrand = "CestQuoiCeNomDeFou";
        final String nomValide = "SuperNom12";

        assertFalse(ValidationCompte.validerNom(nomCaratèreSpécial));
        assertFalse(ValidationCompte.validerNom(nomTropPetit));
        assertFalse(ValidationCompte.validerNom(nomTropGrand));

        assertTrue(ValidationCompte.validerNom(nomValide));
    }

    @Test
    public void testValiderPrenom() {
        final String prénomCaratèreSpécial = "^superprénom^";
        final String prénomTropPetit = "1";
        final String prénomTropGrand = "CestQuoiCeprénomDeFou";
        final String prénomValide = "Superprénom12";

        assertFalse(ValidationCompte.validerNom(prénomCaratèreSpécial));
        assertFalse(ValidationCompte.validerNom(prénomTropPetit));
        assertFalse(ValidationCompte.validerNom(prénomTropGrand));

        assertTrue(ValidationCompte.validerNom(prénomValide));
    }

    @Test
    public void testValiderEtablissementOrigine() {
        final String etabCaratèreSpécial = "^superÉtab^";
        final String etabTropPetit = "1234";
        final String etabTropGrand = "CestQuoiCeÉtabDeFouQuiFaitPlusDe30Caractères";
        final String etabValide = "SuperÉtab12";

        assertFalse(ValidationCompte.validerNom(etabCaratèreSpécial));
        assertFalse(ValidationCompte.validerNom(etabTropPetit));
        assertFalse(ValidationCompte.validerNom(etabTropGrand));

        assertTrue(ValidationCompte.validerNom(etabValide));
    }

    @Test
    public void testValiderVilleStage() {
        final String villeCaratèreSpécial = "^superVille^";
        final String villeTropPetit = "1234";
        final String villeTropGrand = "CestQuoiCeVilleDeFouQuiFaitPlusDe30Caractères";
        final String villeValide = "SuperVille12";

        assertFalse(ValidationCompte.validerNom(villeCaratèreSpécial));
        assertFalse(ValidationCompte.validerNom(villeTropPetit));
        assertFalse(ValidationCompte.validerNom(villeTropGrand));

        assertTrue(ValidationCompte.validerNom(villeValide));
    }

    @Test
    public void testValiderJoindre() {
        final String joindreInvalide = "duNimporteQuoi";
        final String joindreUrl = "unurl.tres.special";
        final String joindreCourriel = "uncourriel@etrange.org";
        final String joindreTelephone = "450-293-2934";

        assertFalse(ValidationCompte.validerJoindre(joindreInvalide));

        assertTrue(ValidationCompte.validerJoindre(joindreUrl));
        assertTrue(ValidationCompte.validerJoindre(joindreCourriel));
        assertTrue(ValidationCompte.validerJoindre(joindreTelephone));
    }

    @Test
    public void testValiderCommentaire() {
        final String commentaireCaratèreSpécial = "^superCommentaire^";
        final String commentaireTropGrand = "CestQuoiCeCommentaireDeFouQuiFaitPlusDe30Caractères";
        final String commentaireValide = "SuperCommentaire12";

        assertFalse(ValidationCompte.validerNom(commentaireCaratèreSpécial));
        assertFalse(ValidationCompte.validerNom(commentaireTropGrand));

        assertTrue(ValidationCompte.validerNom(commentaireValide));
    }

    @Test
    public void testValiderCreationCompte() {

    }

    @Test
    public void testValiderModificationCompte() {

    }
}
