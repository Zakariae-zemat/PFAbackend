package backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.backend.entities.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, String> {
  
}
