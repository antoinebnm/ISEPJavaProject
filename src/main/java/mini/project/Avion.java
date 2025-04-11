package mini.project;

import java.util.ArrayList;

public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;

    private static ArrayList<Avion> listeAvions = new ArrayList<>();
    private ArrayList<Vol> volsAssocies = new ArrayList<>();

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }

    public boolean affecterVol(Vol vol) {
        if (verifierDisponibilite(vol)) {
            volsAssocies.add(vol);
            vol.setAvion(this);
            return true;
        } else {
            System.out.println("Avion non disponible à cette date.");
            return false;
        }
    }

    public boolean verifierDisponibilite(Vol vol) {
        for (Vol v : volsAssocies) {
            if (vol.getDateDepart().before(v.getDateArrivee()) &&
                    v.getDateDepart().before(vol.getDateArrivee())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return modele + " (" + immatriculation + "), capacité: " + capacite + " passagers.";
    }

    // CRUD
    public static void ajouterAvion(Avion a) {
        listeAvions.add(a);
    }

    public static Avion chercherAvion(String immatriculation) {
        for (Avion a : listeAvions) {
            if (a.getImmatriculation().equals(immatriculation)) return a;
        }
        return null;
    }

    public static void supprimerAvion(String immatriculation) {
        listeAvions.removeIf(a -> a.getImmatriculation().equals(immatriculation));
    }

    public static void afficherAvions() {
        for (Avion a : listeAvions) {
            System.out.println(a.toString());
        }
    }

    // Getters / Setters
    public String getImmatriculation() {return immatriculation;}
    public String getModele() {return modele;}
    public int getCapacite() {return capacite;}
}
