package ma.projet.demo.repository;

import ma.projet.demo.entities.Demande;
import ma.projet.demo.security.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande,Long> {

    public List<Demande> findByUserUsername(String username);
}
