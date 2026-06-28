package ch.smartrecruit.smartrecruit.model;

public class Candidat {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String competences;
    private String diplome;
    private int anneesExperience;
    private String localisation;
    private double salaireAttendu;

    public Candidat() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public int getAnneesExperience() {
        return anneesExperience;
    }

    public void setAnneesExperience(int anneesExperience) {
        this.anneesExperience = anneesExperience;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public double getSalaireAttendu() {
        return salaireAttendu;
    }

    public void setSalaireAttendu(double salaireAttendu) {
        this.salaireAttendu = salaireAttendu;
    }
}
