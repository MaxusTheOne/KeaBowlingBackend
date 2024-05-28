package kea.bowlingBackend.security.dto;



import kea.bowlingBackend.security.entity.Role;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.service.UserWithRolesService;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithRolesRequest {
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String email;
    String[] roles;
    String created;
    String edited;

    public UserWithRolesRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public UserWithRoles toUserWithRoles(UserWithRolesService roleService) {
        Set<Role> roleEntities = new HashSet<>();
        if (roles != null) {
            for (String role : roles) {
                roleEntities.add(roleService.getRoleByName(role));
            }
        }
        return new UserWithRoles(username, email, roleEntities, LocalDateTime.parse(created), LocalDateTime.parse(edited));
    }



}