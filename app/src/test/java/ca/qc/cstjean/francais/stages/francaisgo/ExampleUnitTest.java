package ca.qc.cstjean.francais.stages.francaisgo;

import com.google.android.gms.maps.model.LatLng;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.UUID;

public class ExampleUnitTest {

    @Test
    public void ValidationCreationUtilisateur() {
        Utilisateur usager1 =
                new Utilisateur(UUID.randomUUID(), new LatLng(1,1), "Richer101", "motPasseBeton", "Richer", "Alexis", "Montréal",
                                "Lyons", "(444)444-1234", "Bonjour!");

        assertEquals(usager1.getNom(), "Richer");
    }
}