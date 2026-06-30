package ch.smartrecruit.smartrecruit.service;

import ch.smartrecruit.smartrecruit.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.smartrecruit.smartrecruit.model.Candidat;
import java.util.List;

@Service
public class CandidatService {

    private CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository){
    this.candidatRepository = candidatRepository;
    }

    public List<Candidat> getAllCandidats(){
        return candidatRepository.findAll();
    }

    public Candidat getCandidatByID(int id){
        return candidatRepository.findById(id);
    }

    public Candidat findByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }

    public Candidat createCandidat(Candidat c) {
        if (candidatRepository.findByEmail(c.getEmail()) != null) {
            throw new IllegalArgumentException("Un candidat avec cet email existe déjà");
        }
        candidatRepository.save(c);
        return c;
    }

    public void deleteCandidat(int id) {
        candidatRepository.deleteById(id);
    }

}
