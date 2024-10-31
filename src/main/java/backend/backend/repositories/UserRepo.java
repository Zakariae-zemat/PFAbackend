package backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.backend.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    backend.backend.entities.User findByUsername(String username);
} 
