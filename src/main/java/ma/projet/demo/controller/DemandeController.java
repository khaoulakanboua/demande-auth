package ma.projet.demo.controller;


import ma.projet.demo.entities.Demande;
import ma.projet.demo.security.springjwt.models.User;
import ma.projet.demo.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/demande")
public class DemandeController {

    @Autowired
    DemandeService demandeService;

    @GetMapping("/all")
    public List<Demande> findAll() {
        return demandeService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Demande demande) {
        demandeService.save(demande);
    }

    @GetMapping("/id/{id}")
    public Demande findById(@PathVariable Long id) {
        return demandeService.findById(id);
    }
    @PutMapping("/update/{id}")
    public Demande save(@RequestBody Demande p,@PathVariable long id) {
        Demande demande = demandeService.findById(id);
        if (demande != null) {
            if (p.getTitre() != null) {
                demande.setTitre(p.getTitre());

            }
            if (p.getDescription() != null) {
                demande.setDescription(p.getDescription());
            }
            if(p.getComite() != null) {
                demande.setComite(p.getComite());
            }
            if(p.getEtat() != null) {
                demande.setEtat(p.getEtat());
            }
            if(p.getDate_debut() != null) {
                demande.setDate_debut(p.getDate_debut());
            }
            if(p.getDate_fin() != null) {
                demande.setDate_fin(p.getDate_fin());
            }
            if(p.getType() != null) {
                demande.setType(p.getType());
            }
            if(p.getUser() != null) {
                demande.setUser(p.getUser());
            }
            demandeService.save(demande);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        demandeService.deleteById(id);
    }

    @PutMapping("/reject/{id}/{motif}")
    public void RejectDemande(@PathVariable Long id,@PathVariable String motif) {
        demandeService.rejectDemande(id,motif);
    }

    @PutMapping("/accept/{id}")
    public void AcceptDemande(@PathVariable Long id) {
        demandeService.acceptDemande(id);
    }

    @GetMapping("/findbyuser/{username}")
    public List<Demande> findByUserUsername(@PathVariable String username) {
        return demandeService.findByUserUsername(username);
    }
}
