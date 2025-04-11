package mini.project;

import java.util.ArrayList;

public class Aeroport {
    private String nom;
    private String ville;
    private String description;

    private static ArrayList<Aeroport> listeAeroports = new ArrayList<>();
    private ArrayList<Avion> avions = new ArrayList<>();

    public Aeroport(String nom, String ville, String description) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
    }

    public boolean affecterVol(Vol vol) {
        for (Avion avion : avions) {
            if (avion.affecterVol(vol)) {
                System.out.println("Vol affecté à l'avion " + avion.getImmatriculation());
                return true;
            }
        }
        System.out.println("Aucun avion disponible pour ce vol à l'aéroport " + nom);
        return false;
    }

    public void ajouterAvion(Avion avion) {
        avions.add(avion);
    }

    public void supprimerAvion(String immatriculation) {
        avions.removeIf(a -> a.getImmatriculation().equals(immatriculation));
    }

    // CRUD
    public static void ajouterAeroport(Aeroport a) {
        listeAeroports.add(a);
    }

    public static Aeroport chercherAeroport(String nom) {
        for (Aeroport a : listeAeroports) {
            if (a.getNom().equals(nom)) return a;
        }
        return null;
    }

    public static void supprimerAeroport(String nom) {
        listeAeroports.removeIf(a -> a.getNom().equals(nom));
    }

    public static void afficherAeroports() {
        for (Aeroport a : listeAeroports) {
            System.out.println(a.getNom() + " - " + a.getVille() + " (" + a.getDescription() + ")");
        }
    }

    // Getters / Setters
    public String getNom() {return nom;}
    public String getVille() {return ville;}
    public String getDescription() {return description;}
}