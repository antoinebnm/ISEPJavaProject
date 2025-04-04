package java.project;

import java.util.Date;

abstract class Employe extends Personne {
    private int numeroEmploye;
    private Date dateEmbauche;

    public Employe(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    public abstract String obtenirRole();

    // Getters / Setters
    public int getNumeroEmploye() { return numeroEmploye; }
    public void setNumeroEmploye(int n) { this.numeroEmploye = n; }
    public Date getdateEmbauche() { return dateEmbauche; }
    public void setdateEmbauche(Date d) { this.dateEmbauche = d; }
}
