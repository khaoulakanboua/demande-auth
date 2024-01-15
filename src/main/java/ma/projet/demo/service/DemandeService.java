package ma.projet.demo.service;


import ma.projet.demo.entities.Demande;
import ma.projet.demo.repository.DemandeRepository;
import ma.projet.demo.security.springjwt.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    @Autowired
    DemandeRepository demandeRepository;

    public List<Demande> findAll() {
        return demandeRepository.findAllDesc();
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

    public List<Demande> findByUserUsername(String username) {
        return demandeRepository.findByUserUsernameOrderByIdDesc(username);
    }

    public void rejectDemande(Long demandeId,String motif) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);

        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setEtat("rejected");
            demande.setMotif(motif);
            demandeRepository.save(demande);
        } else {
            System.out.print("Demande non trouvée avec l'ID : " + demandeId);
        }
    }

    public void acceptDemande(Long demandeId) {
        Optional<Demande> demandeOptional = demandeRepository.findById(demandeId);

        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            demande.setEtat("accepted");
            demandeRepository.save(demande);
        } else {
            System.out.print("Demande non trouvée avec l'ID : " + demandeId);
        }
    }

}