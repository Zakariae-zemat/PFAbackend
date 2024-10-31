package backend.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.backend.entities.Job;
import backend.backend.repositories.JobRepo;

@Service
public class JobService {
    
    @Autowired
    private JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public List<Job> fetchAllJobs() {
        try {
            return jobRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch jobs: " + e.getMessage());
        }
    }
}
