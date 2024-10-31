package backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.backend.entities.Role;



@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
