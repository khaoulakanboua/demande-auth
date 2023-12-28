package ma.projet.demo.controller;


import ma.projet.demo.entities.Demande;
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

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        demandeService.deleteById(id);
    }

    @PutMapping("reject/{id}")
    public void RejectDemande(@PathVariable Long id) {
        demandeService.rejectDemande(id);
    }

    @PutMapping("accept/{id}")
    public void AcceptDemande(@PathVariable Long id) {
        demandeService.acceptDemande(id);
    }
}
