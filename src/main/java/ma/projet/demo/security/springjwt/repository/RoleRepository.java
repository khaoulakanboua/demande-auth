package ma.projet.demo.security.springjwt.repository;


import ma.projet.demo.security.springjwt.models.ERole;
import ma.projet.demo.security.springjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
