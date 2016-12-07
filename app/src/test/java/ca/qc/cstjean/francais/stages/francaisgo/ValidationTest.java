package ca.qc.cstjean.francais.stages.francaisgo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test pour la classe Validation.
 * Chacune de ses méthodes sont testés vigoureusement.
 * Tous les tests sont effectués avec junit 4.
 *
 * @author Mike Larrivée
 * @version 1.0
 * @see Validation
 */
public class ValidationTest {
    /**
     * Méthode de test pour StringNonVide.
     */
    @Test
    public void testSringNonVide() {
        // Un texte qui ne contient aucun caractères.
        final String texteVide = "";
        // Un texte qui contient plusieurs caractères.
        final String texteNonVide = "Un petit texte";

        // La méthode doit retourner false
        assertFalse(Validation.stringNonVide(texteVide));

        // La méthode doit retourner true
        assertTrue(Validation.stringNonVide(texteNonVide));
    }

    /**
     * Méthode de test pour TailleMinimum
     */
    @Test
    public void testTailleMinimum() {
        // Un texte de taille trop petite, le texte doit être invalide.
        final String texteTropPetit = "1234";
        // Un texte égal au minimum, le texte doit être valide.
        final String texteEgal = "12345";
        // Un texte plus grand que le minimum, le texte doit être valide.
        final String textePlusGrand = "123456";
        // La taille minimum pour la validation.
        final int tailleMinimum = 5;

        // La méthode doit retourner false
        assertFalse(Validation.tailleMinimum(texteTropPetit, tailleMinimum));

        // Les méthodes doivent retourner true
        assertTrue(Validation.tailleMinimum(texteEgal, tailleMinimum));
        assertTrue(Validation.tailleMinimum(textePlusGrand, tailleMinimum));
    }

    /**
     * Méthode de test pour TailleMaximum
     */
    @Test
    public void testTailleMaximum() {
        // Un texte trop grand, le texte doit être invalide.
        final String texteTropGrand = "123456";
        // Un texte égal au maximum, le texte doit être valide.
        final String texteEgal = "12345";
        // Un texte plus petit que le maximum, le texte doit être valide.
        final String textePlusPetit = "1234";
        // La taille maximum pour la validation.
        final int tailleMaximum = 5;

        // La méthode doit retourner false
        assertFalse(Validation.tailleMaximum(texteTropGrand, tailleMaximum));

        //Les méthodes doivent retourner true
        assertTrue(Validation.tailleMaximum(texteEgal, tailleMaximum));
        assertTrue(Validation.tailleMaximum(textePlusPetit, tailleMaximum));
    }

    /**
     * Méthode de test pour SaisieTexteIntervalle
     */
    @Test
    public void testSaisieTexteIntervalle() {
        // Un texte trop grand, le texte doit être invalide.
        final String texteTropGrand = "1234567";
        // Un texte trop petit, le texte doit être invalide.
        final String texteTropPetit = "123";
        // Un texte égal au minimum, le texte doit être valide.
        final String texteEgalPetit = "1234";
        // Un texte égal au maximum, le texte doit être valide.
        final String texteEgalGrand = "123456";
        // Un texte entre le minimum et le maximum, le texte doit être valide.
        final String texteMillieu = "12345";
        // La taille minimum pour la validation.
        final int tailleMinimum = 4;
        // La taille maximum pour la validation.
        final int tailleMaximum = 6;

        // Les méthodes doivent retourner false
        assertFalse(Validation.saisieTexteIntervalle(texteTropGrand, tailleMinimum, tailleMaximum));
        assertFalse(Validation.saisieTexteIntervalle(texteTropPetit, tailleMinimum, tailleMaximum));

        // Les méthodes doivent retourner true
        assertTrue(Validation.saisieTexteIntervalle(texteEgalPetit, tailleMinimum, tailleMaximum));
        assertTrue(Validation.saisieTexteIntervalle(texteEgalGrand, tailleMinimum, tailleMaximum));
        assertTrue(Validation.saisieTexteIntervalle(texteMillieu, tailleMinimum, tailleMaximum));
    }

    /**
     * Méthode de test pour EstAlphaNumérique
     */
    @Test
    public void testEstAlphaNumérique() {
        // Un texte qui contient plusieurs caractères spéciaux, le texte doit être invalide.
        final String texteAvecCaractèresSpéciaux = "fjdjf 49375 `^¨:$$djdfh 3453";
        // Un texte avec uniquement des caractères alphaNumérique, le texte doit être valide.
        final String texteAlphaNumérique = "jgfg oe208487 572";

        // La méthode doit retourner false
        assertFalse(Validation.estAlphaNumérique(texteAvecCaractèresSpéciaux));

        // La méthode doit retourner true
        assertTrue(Validation.estAlphaNumérique(texteAlphaNumérique));
    }

    /**
     * Méthode de test pour FormatTelephoneValide
     */
    @Test
    public void testFormatTelephoneValide() {
        // Un texte contenant un numéro de téléphone invalide.
        final String numéroInvalide = "452389-39274-238957";
        // Un texte contenant un numéro canadien valide.
        final String numéroCanadienValide = "450-372-9032";
        // Un texte contenant un numéro français valide.
        final String numéroFrançaisValide = "03 09 19 36 82";

        // La méthode doit retourner false
        assertFalse(Validation.formatTelephoneValide(numéroInvalide));

        // Les méthodes doivent retourner true
        assertTrue(Validation.formatTelephoneValide(numéroCanadienValide));
        assertTrue(Validation.formatTelephoneValide(numéroFrançaisValide));
    }

    /**
     * Méthode de test pour CourrielValide
     */
    @Test
    public void testCourrielValide() {
        // Un texte contenant un courriel sans @, le texte doit être invalide.
        final String adresseCourrielInvalide = "jdsflh.fsdhfs.dsofh@sdgfohsg";
        // Un texte contenant un courriel valide.
        final String adresseCourrielValide = "fdsfihsdf.dsafhsdof@fsdhfsdfh.com";

        // La méthode doit retourner false
        assertFalse(Validation.courrielValide(adresseCourrielInvalide));

        // La méthode doit retourner true
        assertTrue(Validation.courrielValide(adresseCourrielValide));
    }

    /**
     * Méthode de test pour EstUrlValide
     */
    @Test
    public void testEstUrlValide() {
        // Un texte contenant un url invalide car c'est un courriel.
        final String urlInvalide = "test.exemple@com";
        // Un texte contenant un url sécurisé donc https://
        final String urlSécuriséValide = "https://www.google.ca";
        // Un texte contenant un url http valide.
        final String urlRégulierValide = "http://facebook.com";
        // Un texte contenant un url simplifié valide.
        final String urlSimplifié = "twitter.ca";

        // La méthode doit retourner false
        assertFalse(Validation.estUrlValide(urlInvalide));

        // Les méthodes doivent retourner true
        assertTrue(Validation.estUrlValide(urlSécuriséValide));
        assertTrue(Validation.estUrlValide(urlRégulierValide));
        assertTrue(Validation.estUrlValide(urlSimplifié));
    }
}
