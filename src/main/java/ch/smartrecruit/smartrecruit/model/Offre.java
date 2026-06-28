package ch.smartrecruit.smartrecruit.model;

public class Offre {

    private int id;
    private String titre;
    private String description;
    private String competencesRequises;
    private String diplomeRequis;
    private double salairePropose;
    private String localisation;
    private TypeContrat typeContrat;

    public Offre() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompetencesRequises() {
        return competencesRequises;
    }

    public void setCompetencesRequises(String competencesRequises) {
        this.competencesRequises = competencesRequises;
    }

    public String getDiplomeRequis() {
        return diplomeRequis;
    }

    public void setDiplomeRequis(String diplomeRequis) {
        this.diplomeRequis = diplomeRequis;
    }

    public double getSalairePropose() {
        return salairePropose;
    }

    public void setSalairePropose(double salairePropose) {
        this.salairePropose = salairePropose;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public TypeContrat getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(TypeContrat typeContrat) {
        this.typeContrat = typeContrat;
    }
}