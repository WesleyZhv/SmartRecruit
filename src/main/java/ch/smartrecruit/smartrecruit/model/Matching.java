package ch.smartrecruit.smartrecruit.model;

import java.sql.Timestamp;

public class Matching {

    private int id;
    private int candidatId;
    private int offreId;
    private double score;
    private Timestamp dateMatching;

    public Matching() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }

    public int getOffreId() {
        return offreId;
    }

    public void setOffreId(int offreId) {
        this.offreId = offreId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Timestamp getDateMatching() {
        return dateMatching;
    }

    public void setDateMatching(Timestamp dateMatching) {
        this.dateMatching = dateMatching;
    }
}