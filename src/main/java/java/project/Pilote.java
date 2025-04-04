package java.project;

import java.util.Date;

abstract class Pilote extends Employe {
    private String licence;
    private int heuresDeVol;

    public Pilote(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche, String licence, int heuresDeVol) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.licence = licence;
        this.heuresDeVol = heuresDeVol;
    }

    @Override
    public String obtenirRole() {
        return "Pilote";
    }

    // Getters / Setters
    public String getLicence() {return this.licence;}
    public void setLicence(String l) {this.licence = l;}
    public int getHeures() {return this.heuresDeVol;}
    public void setHeures(int h) {this.heuresDeVol = h;}
}