package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;
    private final AuthenticationService authService;

    public DataInitializer(UserService userService, RoleService roleService,
                           AuthenticationService authService) {
        this.userService = userService;
        this.roleService = roleService;
        this.authService = authService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRole(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRole(Role.RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@i.ua");
        user.setPassword("admin123");
        user.setRoles(Set.of(adminRole));
        userService.add(user);

        authService.register("test@i.ua", "test1111");
    }

}
