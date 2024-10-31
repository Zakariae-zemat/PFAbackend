package backend.backend.services;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.backend.entities.Role;
import backend.backend.entities.User;
import backend.backend.repositories.RoleRepo;
import backend.backend.repositories.UserRepo;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class AccMngImpl implements AccountManager {


    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    // Utilisez @Lazy ici pour éviter la création anticipée de beans et casser la boucle
    public AccMngImpl(UserRepo userRepo, RoleRepo roleRepo, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepo.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepo.save(role);
    }


    @Override
    public User addRoleUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByRoleName(roleName);

        user.getRoles().add(role);
        userRepo.save(user);

        return user;
    }

    @Override
    public List<Role> getUserRoles(String username) {
        User user = userRepo.findByUsername(username);
        return user.getRoles();
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }


}
