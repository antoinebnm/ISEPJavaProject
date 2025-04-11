package mini.project;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private int numeroReservation;
    private Passager passager;
    private Vol vol;
    private Date dateReservation;

    private static ArrayList<Reservation> listeReservations = new ArrayList<>();

    public Reservation(int numeroReservation, Passager passager, Vol vol, Date dateReservation) {
        this.numeroReservation = numeroReservation;
        this.passager = passager;
        this.vol = vol;
        this.dateReservation = dateReservation;
    }

    public void afficherDetails() {
        System.out.println("Réservation #" + numeroReservation);
        System.out.println("Passager : " + passager.getNom());
        System.out.println("Vol : " + vol.getNumeroVol());
        System.out.println("Date de réservation : " + dateReservation);
    }

    // CRUD
    public static void ajouterReservation(Reservation r) {
        listeReservations.add(r);
    }

    public static boolean supprimerReservation(int numero) {
        return listeReservations.removeIf(r -> r.getNumeroReservation() == numero);
    }

    public static ArrayList<Reservation> getListeReservations() {
        return listeReservations;
    }

    // Getters / Setters
    public int getNumeroReservation() {return numeroReservation;}
    public Passager getPassager() {return passager;}
    public Vol getVol() {return vol;}
    public Date getDateReservation() {return dateReservation;}
}