package backend.backend.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.entities.Job;
import backend.backend.services.JobService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class JobController {
    
    
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        System.out.println("JobController: fetchAllJobs method called");
        return jobService.fetchAllJobs();
    }
}
