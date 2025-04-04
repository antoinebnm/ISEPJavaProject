package mini.project;

import java.util.Date;

public class UnitTests {
    public static void main(String[] args) {
        testAvion();
        testAeroportEtVol();
        testPassagerEtReservation();
    }

    public static void testAvion() {
        System.out.println("=== TEST AVION ===");

        Avion a1 = new Avion("F123AB", "Airbus A320", 180);
        Avion a2 = new Avion("F456CD", "Boeing 737", 200);

        System.out.println("Avion 1 : " + a1.getImmatriculation() + ", modèle " + a1.getModele());

        Date dep1 = new Date(2025, 4, 4, 10, 0);
        Date arr1 = new Date(2025, 4, 4, 12, 0);
        Vol v1 = new Vol(1, null, null, dep1, arr1);
        a1.affecterVol(v1);

        Date dep2 = new Date(2025, 4, 4, 11, 0);
        Date arr2 = new Date(2025, 4, 4, 13, 0);
        Vol v2 = new Vol(2, null, null, dep2, arr2);

        System.out.println("Disponibilité avion pour 2e vol : " + a1.verifierDisponibilite(v2)); // devrait être false
        System.out.println();
    }

    public static void testAeroportEtVol() {
        System.out.println("=== TEST VOL & AÉROPORT ===");

        Aeroport cdg = new Aeroport("Charles de Gaulle", "CDG", "");
        Aeroport kix = new Aeroport("Osaka", "KIX", "");

        Avion a1 = new Avion("A100", "Airbus A350", 250);
        cdg.ajouterAvion(a1);

        Date dep = new Date(2025, 4, 4, 15, 0);
        Date arr = new Date(2025, 4, 4, 18, 0);
        Vol vol1 = new Vol(100, cdg, kix, dep, arr);

        boolean affecte = cdg.affecterVol(vol1);
        System.out.println("Vol affecté à un avion : " + affecte);
        System.out.println("Avion assigné : " + vol1.getAvion().getImmatriculation());
        System.out.println();
    }

    public static void testPassagerEtReservation() {
        System.out.println("=== TEST PASSAGER & RESERVATION ===");

        Date dep1 = new Date(2025, 4, 4, 10, 0); // peut générer une erreur: Calendar.APRIL
        Date arr1 = new Date(2025, 4, 4, 12, 0);
        Vol vol = new Vol(1, null, null, dep1, arr1);

        Passager p1 = new Passager(1, "Nicola Comme", "Paris", "0600000000");
        Reservation r1 = new Reservation(101, p1, vol, dep1); // dep1 = jour du départ
        Reservation r2 = new Reservation(102, p1, vol, dep1);

        p1.reserverVol(r1);
        p1.reserverVol(r2);

        System.out.println("Réservations de " + p1.getNom() + " :");
        for (Reservation r : Reservation.getListeReservations()) {
            if (r.getPassager().equals(p1)) {
                System.out.println("- Réservation #" + r.getNumeroReservation());
            }
        }

        boolean supprime = Reservation.supprimerReservation(101);
        System.out.println("Suppression réservation 101 : " + supprime);
        System.out.println();
    }
}