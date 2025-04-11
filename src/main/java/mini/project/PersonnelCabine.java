package mini.project;

import java.util.Date;

class PersonnelCabine extends Employe {
    private String qualification;

    public PersonnelCabine(int identifiant, String nom, String adresse, String contact, int numeroEmploye, Date dateEmbauche, String qualification) {
        super(identifiant, nom, adresse, contact, numeroEmploye, dateEmbauche);
        this.qualification = qualification;
    }

    @Override
    public String obtenirRole() {
        return "Personnel Cabine";
    }

    // Getters / Setters
    public String getQualification() { return qualification; }
}