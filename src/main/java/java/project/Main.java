package java.project;

public class Main {
    public static void main(String[] args) {
        Personne p1 = new Personne(128, "Antoine Caliez", "a@b.com", "0607");
        p1.obtenirInfos();
        Personne.ajouter(p1);
    }
}