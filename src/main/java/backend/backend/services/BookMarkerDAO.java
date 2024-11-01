package backend.backend.services;

import java.util.Set;

import backend.backend.entities.Job;

public interface BookMarkerDAO {

    boolean addMarkedJob(String username, String jobId);
    boolean removeMarkedJob(String username, String jobId);
    Set<Job> getMarkedJobs(String username);

}
