package ch.smartrecruit.smartrecruit.service;

import ch.smartrecruit.smartrecruit.repository.MatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.smartrecruit.smartrecruit.model.Matching;
import java.util.List;

@Service
public class MatchingService {

    private MatchingRepository matchingRepository;

    @Autowired
    public MatchingService(MatchingRepository matchingRepository){
        this.matchingRepository = matchingRepository;
    }

    public List<Matching> getMatchingsForCandidat(int candidatId){
        return matchingRepository.findByCandidatId(candidatId);
    }

    public List<Matching> getMatchingsForOffre(int offreId){
        return matchingRepository.findByOffreId(offreId);
    }

}
