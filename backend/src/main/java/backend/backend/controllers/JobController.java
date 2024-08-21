package backend.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.entities.Job;
import backend.backend.services.JobService;

@RestController
@RequestMapping("/api/v1")
    
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class JobController {
    
    @Autowired
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
