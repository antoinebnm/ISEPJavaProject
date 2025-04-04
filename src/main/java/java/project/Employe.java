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

    public int getNumeroEmploye() {return numeroEmploye;}

    public abstract String obtenirRole();
}
