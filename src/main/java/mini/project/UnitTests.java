package mini.project;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class UnitTests {

    private Avion a1;
    private Date dep1;
    private Date arr1;
    private Vol v1;
    private Date dep2;
    private Date arr2;
    private Vol v2;
    private Aeroport cdg;
    private Aeroport kix;
    private Aeroport orly;
    private Date dep;
    private Date arr;
    private Vol vol1;
    private Passager p1;
    private Reservation r1;
    private Reservation r2;


    @BeforeEach
    void Init() {
        a1 = new Avion("F123AB", "Airbus A320", 180);
        dep1 = new Date(2025, 4, 4, 10, 0);
        arr1 = new Date(2025, 4, 4, 12, 0);
        v1 = new Vol(1, null, null, dep1, arr1);
        dep2 = new Date(2025, 4, 4, 11, 0);
        arr2 = new Date(2025, 4, 4, 13, 0);
        v2 = new Vol(2, null, null, dep2, arr2);
        cdg = new Aeroport("Charles de Gaulle", "CDG", "");
        kix = new Aeroport("Osaka", "KIX", "");
        orly = new Aeroport("Orly", "Paris", "");
        cdg.ajouterAvion(a1);
        dep = new Date(2025, 4, 4, 15, 0);
        arr = new Date(2025, 4, 4, 18, 0);
        vol1 = new Vol(100, cdg, kix, dep, arr);
        vol1.planifierVol(vol1);
        p1 = new Passager(1, "Nicola Comme", "Paris", "0600000000");
        r1 = new Reservation(101, p1, vol1, dep1); // dep1 = jour du départ
        Reservation r2 = new Reservation(102, p1, vol1, dep1);
        p1.reserverVol(r1);
        p1.reserverVol(r2);

    }

    @Test
    public void testAvion() {
        // test getter imatriculation
        assertEquals("F123AB", a1.getImmatriculation());

        // test getter modele
        assertEquals("Airbus A320", a1.getModele());

        // test getter capacité
        assertEquals(180, a1.getCapacite());

        a1.affecterVol(v1);
        // test affecterVol()
        assertEquals(v1.getAvion(),a1);

        // test verifierDisponibilite()
        assertFalse(a1.verifierDisponibilite(v2));
    }

    @Test
    public void testAeroportEtVol() {
        // test affecterVol()
        assertTrue(cdg.affecterVol(vol1));
        assertEquals("F123AB", vol1.getAvion().getImmatriculation());

        // test plannifierVol
        assertTrue(vol1.getVols().contains(vol1));

        Vol.annulerVol(vol1.getNumeroVol());
        //test annulerVol
        assertEquals("Annulé", vol1.getEtat());

        vol1.modifierVol(orly, cdg, dep1, arr1);
        //test modifierVol
        assertEquals(vol1.getOrigine(), orly);
        assertEquals(vol1.getDestination(), cdg);

        vol1.ajouterPassager(p1);
        //test listingPassagers
        assertEquals(vol1.listingPassagers(), p1);
    }

    @Test
    public void testPassagerEtReservation() {
        // test reservervol
        assertEquals(p1, r1.getPassager());

        // test supprimerReservation
        Reservation.supprimerReservation(101);
        assertFalse(Reservation.getListeReservations().contains(r1));


        p1.reserverVol(r1);
        // reserverVol
        assertEquals(p1, r1.getPassager());

        p1.annulerReservation(101);
        // annulerReservation
        assertFalse(Reservation.getListeReservations().contains(r1));


        //obtenirReservations

    }
}