package ma.projet.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.projet.demo.entities.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    List<Zone> findByCityId(Long cityId);
}