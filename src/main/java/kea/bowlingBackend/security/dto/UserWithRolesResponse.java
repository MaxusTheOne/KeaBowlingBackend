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
    String userName;
    List<String> roles;
    String email;
    String created;
    String edited;


    public UserWithRolesResponse(UserWithRoles userWithRoles){

        this.id =  userWithRoles.getUserId().toString();
        this.userName = userWithRoles.getUsername();
        this.roles = userWithRoles.getRoles().stream().map(Role::getRoleName).toList();
        this.email = userWithRoles.getEmail();
        this.created = userWithRoles.getCreated().toString();
        this.edited = userWithRoles.getEdited().toString();
    }

}
