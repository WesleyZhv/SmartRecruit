package ch.smartrecruit.smartrecruit.repository;

import ch.smartrecruit.smartrecruit.model.Candidat;
import ch.smartrecruit.smartrecruit.model.Offre;
import ch.smartrecruit.smartrecruit.model.TypeContrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OffreRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OffreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Offre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Offre o = new Offre();
        o.setId(rs.getInt("id"));
        o.setTitre(rs.getString("titre"));
        o.setDescription(rs.getString("description"));
        o.setCompetencesRequises(rs.getString("competences_requises"));
        o.setDiplomeRequis(rs.getString("diplome_requis"));
        o.setSalairePropose(rs.getDouble("salaire_propose"));
        o.setLocalisation(rs.getString("localisation"));
        o.setTypeContrat(TypeContrat.valueOf(rs.getString("type_contrat")));
        return o;
    }

    public List<Offre> findAll() {
        return jdbcTemplate.query("SELECT * FROM offres", this::mapRow);
    }

    public Offre findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM offres WHERE id = ?",
                (rs, rowNum) -> mapRow(rs, rowNum),
                id
        );
    }

    public void save(Offre o) {
        jdbcTemplate.update(
                "INSERT INTO offres (titre, description, competences_requises, diplome_requis, salaire_propose, localisation, type_contrat) VALUES (?, ?, ?, ?, ?, ?, ?)",
                o.getTitre(),
                o.getDescription(),
                o.getCompetencesRequises(),
                o.getDiplomeRequis(),
                o.getSalairePropose(),
                o.getLocalisation(),
                o.getTypeContrat().name()
        );
    }

    public void deleteById(int id) {
            jdbcTemplate.update("DELETE FROM offres WHERE id = ?", id);
        }
}
