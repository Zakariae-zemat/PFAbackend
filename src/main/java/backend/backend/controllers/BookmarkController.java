package backend.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import backend.backend.DTO.BookMarkDTO;
import backend.backend.entities.Job;
import backend.backend.services.BookmarkedJobsImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class BookmarkController {

    @Autowired
    BookmarkedJobsImpl bookmarkedJobsImpl;

    public BookmarkController(BookmarkedJobsImpl bookmarkedJobsImpl) {
        this.bookmarkedJobsImpl = bookmarkedJobsImpl;
    }


    @PostMapping("/markJob")
    public String markJob(@RequestBody BookMarkDTO bookMarkDTO) {
        bookmarkedJobsImpl.addMarkedJob(bookMarkDTO.getUsername(), bookMarkDTO.getJobId());
        return "Job is added to favoris list";
    }

    @GetMapping("/getMarkedJobs")
    public Set<Job> getMarkedJobs(String username) {
        return bookmarkedJobsImpl.getMarkedJobs(username);
    }

    @DeleteMapping("/removeBookMark")
    public String removeBookMark(@RequestBody BookMarkDTO bookMarkDTO){
        bookmarkedJobsImpl.removeMarkedJob(bookMarkDTO.getUsername(), bookMarkDTO.getJobId());
        return "Job is deleted from favoris";
    }
    
    


}
