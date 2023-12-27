package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.projet.demo.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
}
