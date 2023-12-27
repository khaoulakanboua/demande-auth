package ma.projet.demo.service;


import ma.projet.demo.entities.Demande;
import ma.projet.demo.repository.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeService {

    @Autowired
    DemandeRepository demandeRepository;

    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }

    public void save(Demande demande) {
        demandeRepository.save(demande);
    }

    public Demande findById(Long id) {
        return demandeRepository.findById(id).get();
    }

    public void deleteById(Long aLong) {
        demandeRepository.deleteById(aLong);
    }
}