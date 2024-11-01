package backend.backend.controllers;


import org.springframework.web.bind.annotation.RestController;

import backend.backend.DTO.AuthResponseDTO;
import backend.backend.DTO.LoginDTO;
import backend.backend.DTO.RoleUserForm;
import backend.backend.entities.User;
import backend.backend.security.CustomUserDetailsService;
import backend.backend.security.JwtUtil;
import backend.backend.services.AccMngImpl;
import java.util.List;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AccountController {

    private final AuthenticationManager authenticationManager;
    private final AccMngImpl accMngImpl;

    @Autowired
    public AccountController(@Lazy AuthenticationManager authenticationManager, AccMngImpl accMngImpl) {
        this.authenticationManager = authenticationManager;
        this.accMngImpl = accMngImpl;
    }
    @Autowired
    private CustomUserDetailsService customUserDetailsService ;
    @Autowired
    private JwtUtil jwtUtil;

    

    @GetMapping("/users")
    public List<User> getUsers() {
        return accMngImpl.getAll();
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        return accMngImpl.addUser(user);
    }

    @PostMapping("/roleTouser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
        accMngImpl.addRoleUser(roleUserForm.getUsername(), roleUserForm.getRolename());
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
}
