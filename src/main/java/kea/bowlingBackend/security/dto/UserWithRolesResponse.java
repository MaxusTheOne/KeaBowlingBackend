package kea.bowlingBackend.security.dto;


import kea.bowlingBackend.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithRolesResponse {
    String userName;
    List<String> roleNames;
    String email;
    String created;
    String edited;


    public UserWithRolesResponse(UserWithRoles userWithRoles){
        this.userName = userWithRoles.getUsername();
        this.roleNames = userWithRoles.getRoles().stream().map(role -> role.getRoleName()).toList();
        this.email = userWithRoles.getEmail();
        this.created = userWithRoles.getCreated().toString();
        this.edited = userWithRoles.getEdited().toString();
    }

}
