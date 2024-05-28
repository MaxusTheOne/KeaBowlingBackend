package kea.bowlingBackend.security.dto;


import kea.bowlingBackend.security.entity.Role;
import kea.bowlingBackend.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithRolesResponse {
    String id;
    String username;
    List<String> roles;
    String email;
    String created;
    String edited;


    public UserWithRolesResponse(UserWithRoles userWithRoles){

        this.id =  userWithRoles.getUserId().toString();
        this.username = userWithRoles.getUsername();
        this.roles = userWithRoles.getRoles().stream().map(Role::getRoleName).toList();
        this.email = userWithRoles.getEmail();
        this.created = userWithRoles.getCreated().toString().substring(0, 19);
        this.edited = userWithRoles.getEdited().toString().substring(0, 19);
    }

}
