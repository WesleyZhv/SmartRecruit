package ch.smartrecruit.smartrecruit.repository;

import ch.smartrecruit.smartrecruit.model.Matching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MatchingRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MatchingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Matching mapRow(ResultSet rs, int rowNum) throws SQLException {
        Matching m = new Matching();
        m.setId(rs.getInt("id"));
        m.setCandidatId(rs.getInt("candidat_id"));
        m.setOffreId(rs.getInt("offre_id"));
        m.setScore(rs.getDouble("score"));
        m.setDateMatching(rs.getTimestamp("date_matching"));
        return m;
    }

    public List<Matching> findAll() {
        return jdbcTemplate.query("SELECT * FROM matchings", (rs, rowNum) -> mapRow(rs, rowNum));
    }

    public Matching findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM matchings WHERE id = ?",
                (rs, rowNum) -> mapRow(rs, rowNum),
                id
        );
    }

    public List<Matching> findByCandidatId(int candidatId) {
        return jdbcTemplate.query(
                "SELECT * FROM matchings WHERE candidat_id = ? ORDER BY score DESC",
                (rs, rowNum) -> mapRow(rs, rowNum),
                candidatId
        );
    }

    public List<Matching> findByOffreId(int offreId) {
        return jdbcTemplate.query(
                "SELECT * FROM matchings WHERE offre_id = ? ORDER BY score DESC",
                (rs, rowNum) -> mapRow(rs, rowNum),
                offreId
        );
    }

    public void save(Matching m) {
        jdbcTemplate.update(
                "INSERT INTO matchings (candidat_id, offre_id, score) VALUES (?, ?, ?)",
                m.getCandidatId(),
                m.getOffreId(),
                m.getScore()
        );
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM matchings WHERE id = ?", id);
    }
}