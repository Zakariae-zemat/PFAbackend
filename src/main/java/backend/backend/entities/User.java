package backend.backend.entities;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true)
    private String username;

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Role> roles = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
                name = "bookmarkedJobs",
                joinColumns = @JoinColumn(name = "username"),
                inverseJoinColumns = @JoinColumn(name = "job_id")
                )
    Set<Job> markedJobs = new HashSet<>(){
        
    };

    public User() {
        
    }

    public User(String username, String email, String password, List<Role> roles, Set<Job> markedJobs) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.markedJobs = markedJobs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Set<Job> getmarkedJobs() {
        return markedJobs;
    }

    public void setmarkedJobs(Set<Job> markedJobs) {
        this.markedJobs = markedJobs;
    }

}
