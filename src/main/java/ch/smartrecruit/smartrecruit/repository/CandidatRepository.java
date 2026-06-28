package ch.smartrecruit.smartrecruit.repository;

import ch.smartrecruit.smartrecruit.model.Candidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;

@Repository
public class CandidatRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CandidatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Candidat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidat c = new Candidat();
        c.setId(rs.getInt("id"));
        c.setNom(rs.getString("nom"));
        c.setPrenom(rs.getString("prenom"));
        c.setEmail(rs.getString("email"));
        c.setCompetences(rs.getString("competences"));
        c.setDiplome(rs.getString("diplome"));
        c.setAnneesExperience(rs.getInt("annees_experience"));
        c.setLocalisation(rs.getString("localisation"));
        c.setSalaireAttendu(rs.getDouble("salaire_attendu"));
        return c;
    }

    public List<Candidat> findAll() {
        return jdbcTemplate.query("SELECT * FROM candidats", this::mapRow);
    }

    public Candidat findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM candidats WHERE id = ?",
                (rs, rowNum) -> mapRow(rs, rowNum),
                id
        );
    }

    public void save(Candidat c) {
        jdbcTemplate.update(
                "INSERT INTO candidats (nom, prenom, email, competences, diplome, annees_experience, localisation, salaire_attendu) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                c.getNom(),
                c.getPrenom(),
                c.getEmail(),
                c.getCompetences(),
                c.getDiplome(),
                c.getAnneesExperience(),
                c.getLocalisation(),
                c.getSalaireAttendu()
        );
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM candidats WHERE id = ?", id);
    }

}
