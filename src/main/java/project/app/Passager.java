package project.app;

import java.util.ArrayList;

class Passager extends Personne {
    private String passeport;
    private ArrayList<Reservation> reservations;

    public Passager(int identifiant, String nom, String adresse, String contact) {
        super(identifiant, nom, adresse, contact);
        this.reservations = new ArrayList<>();
    }

    @Override
    public void obtenirInfos() {
        System.out.println("Passager : " + getNom() + ", nombre de réservations :" + reservations.size());
    }

    // CRUD
    public void reserverVol(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Réservation ajoutée pour le passager " + getNom());
    }

    public void annulerReservation(int numeroReservation) {
        for (Reservation r : reservations) {
            if (r.getNumeroReservation() == numeroReservation) {
                reservations.remove(r);
                System.out.println("Réservation annulée (ID : " + numeroReservation + ")");
                break;
            }
        }
    }

    public Reservation obtenirReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation pour ce passager.");
            return null;
        }
        for (Reservation r : reservations) {
            System.out.println("Réservation ID : " + r.getNumeroReservation());
            return r;
        }
        return null;
    }

    // Getters / Setters
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
