package project.app;

import java.util.ArrayList;
import java.util.Date;

public class Vol {
    private int numeroVol;
    private Aeroport origine;
    private Aeroport destination;
    private Date dateDepart;
    private Date dateArrivee;
    private String etat;
    private ArrayList<Passager> passagers = new ArrayList<>();
    private Avion avion;
    private Pilote pilote;
    private ArrayList<PersonnelCabine> equipeCabine = new ArrayList<>();

    private static ArrayList<Vol> vols = new ArrayList<>();

    public Vol(int numeroVol, Aeroport origine, Aeroport destination, Date dateDepart, Date dateArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.etat = "Planifié";
    }

    public void affecterVol(Pilote pilote, ArrayList<PersonnelCabine> equipe) {
        this.pilote = pilote;
        this.equipeCabine = equipe;
    }

    public static void annulerVol(int numero) {
        for (Vol v : vols) {
            if (v.getNumeroVol() == numero) {
                v.etat = "Annulé";
                System.out.println("Vol " + numero + " annulé.");
            }
        }
    }

    public static void planifierVol(Vol vol) {
        vols.add(vol);
    }

    public static Vol obtenirVol(int numero) {
        for (Vol v : vols) {
            if (v.getNumeroVol() == numero) return v;
        }
        return null;
    }

    public void modifierVol(Aeroport origine, Aeroport destination, Date dateDepart, Date dateArrivee) {
        this.origine = origine;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.etat = "Modifié";
    }

    public void ajouterPassager(Passager p) {
        passagers.add(p);
    }

    public Passager listingPassagers() {
        System.out.println("Passagers du vol " + numeroVol + " :");
        for (Passager p : passagers) {
            System.out.println(p.getNom());
            return p;
        }
        return null;
    }

    // Getters / Setters
    public int getNumeroVol() {return numeroVol;}
    public Aeroport getOrigine() {return origine;}
    public Aeroport getDestination() {return destination;}
    public Date getDateDepart() {return dateDepart;}
    public Date getDateArrivee() {return dateArrivee;}
    public String getEtat() { return etat; }
    public static ArrayList<Vol> getVols() {return vols;}
    public void setPassagers(ArrayList<Passager> passagers) {this.passagers = passagers;}

    public Avion getAvion() {return avion;}
    public void setAvion(Avion avion) {this.avion = avion;}
}