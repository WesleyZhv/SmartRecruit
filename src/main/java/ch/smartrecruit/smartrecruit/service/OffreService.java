package ch.smartrecruit.smartrecruit.service;

import ch.smartrecruit.smartrecruit.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.smartrecruit.smartrecruit.model.Offre;
import java.util.List;

@Service
public class OffreService {
    private OffreRepository offreRepository;

    @Autowired
    public OffreService(OffreRepository offreRepository){
        this.offreRepository = offreRepository;
    }

    public List<Offre> getAllOffre(){
        return offreRepository.findAll();
    }

    public Offre getOffreById(int id){
        return offreRepository.findById(id);
    }

    public Offre createOffre(Offre o){
    offreRepository.save(o);
    return o;
    }

    public void deleteOffre(int id){
        offreRepository.deleteById(id);
    }
}
