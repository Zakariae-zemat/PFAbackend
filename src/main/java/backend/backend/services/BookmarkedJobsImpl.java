package backend.backend.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import backend.backend.entities.Job;
import backend.backend.entities.User;
import backend.backend.repositories.JobRepo;
import backend.backend.repositories.UserRepo;

@Service
public class BookmarkedJobsImpl implements BookMarkerDAO {

    UserRepo userRepo;
    JobRepo jobRepo;

    public BookmarkedJobsImpl(UserRepo userRepo, JobRepo jobRepo) {
        this.userRepo = userRepo;
        this.jobRepo = jobRepo;
    }

    @Override
    public boolean addMarkedJob(String username, String jobId) {
        User user = userRepo.findByUsername(username);
        Job job = jobRepo.getReferenceById(jobId);
        userRepo.save(user);
        return user.getmarkedJobs().add(job);
    }

    @Override
    public boolean removeMarkedJob(String username, String jobId) {
        User user = userRepo.findByUsername(username);
        Job job = jobRepo.getReferenceById(jobId);
        userRepo.save(user);
        return user.getmarkedJobs().remove(job);
    }

    @Override
    public Set<Job> getMarkedJobs(String username) {

        User user = userRepo.findByUsername(username);
        Set<Job> markedUserjobs = user.getmarkedJobs();
        return markedUserjobs;
    }

    
}
