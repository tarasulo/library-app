package library.app.spring.dto;

import library.app.spring.entity.Role;
import library.app.spring.entity.User;
import library.app.spring.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {

    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public DtoUtil(RoleService roleService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public User parse(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleService.getRoleByName("ROLE_USER").get();
        user.getRoles().add(role);
        return user;
    }
}
