package kea.bowlingBackend.security.dto;



import kea.bowlingBackend.security.entity.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserWithRolesRequest {
    @NonNull
    String username;
    @NonNull
    String password;
    @NonNull
    String email;
    String[] roles;

    public UserWithRolesRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

}