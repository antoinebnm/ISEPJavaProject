package project.utils;

import project.app.*;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDonnees {
    private List<Avion> avions = new ArrayList<>();
    private List<Aeroport> aeroports = new ArrayList<>();
    private List<Vol> vols = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private List<Personne> personnes = new ArrayList<>();

    public List<Avion> getAvions() { return avions; }
    public List<Aeroport> getAeroports() { return aeroports; }
    public List<Vol> getVols() { return vols; }
    public List<Reservation> getReservations() { return reservations; }
    public List<Personne> getPersonnes() { return personnes; }

    public void setAvions(List<Avion> avions) { this.avions = avions; }
    public void setAeroports(List<Aeroport> aeroports) { this.aeroports = aeroports; }
    public void setVols(List<Vol> vols) { this.vols = vols; }
    public void setReservations(List<Reservation> reservations) { this.reservations = reservations; }
    public void setPersonnes(List<Personne> personnes) { this.personnes = personnes; }

    public List<List<?>> getAll() {
        List<List<?>> all = new ArrayList<>();
        all.add(avions);
        all.add(aeroports);
        all.add(vols);
        all.add(reservations);
        all.add(personnes);
        return all;
    }
}