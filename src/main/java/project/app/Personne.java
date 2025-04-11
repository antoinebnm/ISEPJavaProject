package project.app;

import java.util.ArrayList;

public class Personne {
    private int identifiant;
    private String nom;
    private String adresse;
    private String contact;

    private static ArrayList<Personne> personnes = new ArrayList<>();

    public Personne(int identifiant, String nom, String adresse, String contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }

    // CRUD
    public static void ajouter(Personne p) {
        personnes.add(p);
    }

    public static Personne chercherParId(int id) {
        for (Personne p : personnes) {
            if (p.getIdentifiant() == id) return p;
        }
        return null;
    }

    public static boolean modifier(int id, String nouveauNom, String nouvelleAdresse, String nouveauContact) {
        Personne p = chercherParId(id);
        if (p != null) {
            p.setNom(nouveauNom);
            p.setAdresse(nouvelleAdresse);
            p.setContact(nouveauContact);
            return true;
        }
        return false;
    }

    public static boolean supprimer(int id) {
        return personnes.removeIf(p -> p.getIdentifiant() == id);
    }

    public void obtenirInfos() {
        System.out.println("ID: " + identifiant + ", Nom: " + nom + ", Adresse: " + adresse + ", Contact: " + contact);

    }

    // Getters / Setters
    public int getIdentifiant() { return identifiant; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
