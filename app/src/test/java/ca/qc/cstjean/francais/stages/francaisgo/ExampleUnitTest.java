package ca.qc.cstjean.francais.stages.francaisgo;

import com.google.android.gms.maps.model.LatLng;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

import ca.qc.cstjean.francais.stages.francaisgo.Utilisateur;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExampleUnitTest {

    @Test
    public void ValidationCreationUtilisateur() {
        Utilisateur usager1 =
                new Utilisateur(UUID.randomUUID(), new LatLng(1,1), "Richer", "Alexis", "Montréal",
                                "Lyons", "(444)444-1234", "Bonjour!");

        assertEquals(usager1.getNom(), "Richer");
    }
}