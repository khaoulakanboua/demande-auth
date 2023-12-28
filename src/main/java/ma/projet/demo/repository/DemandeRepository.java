package ma.projet.demo.repository;

import ma.projet.demo.entities.Demande;
import ma.projet.demo.security.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends JpaRepository<Demande,Long> {

    public Demande findByUserUsername(String username);
}
