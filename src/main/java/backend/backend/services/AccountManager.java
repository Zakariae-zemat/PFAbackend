package backend.backend.services;

import java.util.List;

import backend.backend.entities.Role;
import backend.backend.entities.User;

public interface AccountManager {

    User addUser(User user);
    Role addRole(Role role);
    User addRoleUser(String username, String roleName);
    List<Role> getUserRoles(String username);
    List<User> getAll();
}
