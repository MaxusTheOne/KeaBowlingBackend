package kea.bowlingBackend.security.api;

import kea.bowlingBackend.security.dto.UserWithRolesRequest;
import kea.bowlingBackend.security.dto.UserWithRolesResponse;
import kea.bowlingBackend.security.entity.Role;
import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.repository.RoleRepository;
import kea.bowlingBackend.security.service.UserWithRolesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserWithRoleController {

  RoleRepository roleRepository;
  UserWithRolesService userWithRolesService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserWithRoleController(UserWithRolesService userWithRolesService, RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
    this.userWithRolesService = userWithRolesService;
  }

  //Anonymous users can call this.
  @PostMapping
  @Operation(summary = "Add a new UserWithRoles user",
          description = "If a default role is defined (app.default-role ), this role will be assigned to the user.")
  public UserWithRolesResponse addUserWithoutRoles(@RequestBody UserWithRolesRequest request) {
    return userWithRolesService.addUserWithoutRoles(request);
  }

  @PostMapping("/add")
  @Operation(summary = "Add a user with roles in a string array")
  public UserWithRolesResponse addUserWithRoles(@RequestBody UserWithRolesRequest userRequest) {
    Set<Role> roles = new HashSet<>();
    for (String roleName : userRequest.getRoles()) {
      Role role = roleRepository.findByRoleName(roleName)
              .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found: " + roleName));
      roles.add(role);
    }

    UserWithRoles newUser = new UserWithRoles(userRequest.getUsername(), passwordEncoder.encode(userRequest.getPassword()), userRequest.getEmail());
    newUser.setRoles(roles);

    return userWithRolesService.addUserWithRoles(newUser);
  }

  //Take care with this. This should NOT be something everyone can call

  @PatchMapping("/role-add/{username}/{role}")
  @Operation(summary = "Add a role to a UserWithRoles", description = "Caller must be authenticated with the role ADMIN")
  public UserWithRolesResponse addRole(@PathVariable String username, @PathVariable String role) {
    return userWithRolesService.addRole(username, role);
  }

  //Take care with this. This should NOT be something everyone can call

  @PatchMapping("/role-remove/{username}/{role}")
  @Operation(summary = "Removes a role from a UserWithRoles", description = "Caller must be authenticated with the role ADMIN")
  public UserWithRolesResponse removeRole(@PathVariable String username, @PathVariable String role) {
    return userWithRolesService.removeRole(username, role);
  }

  //Delete a user from the system.

  @DeleteMapping("/{username}")
  @Operation(summary = "Delete a user", description = "Caller must be authenticated with the role ADMIN")
  public UserWithRolesResponse deleteUser(@PathVariable String username) {
    try {
      return userWithRolesService.deleteUser(username);
    } catch (Exception e) {
      throw new RuntimeException("User not found");
    }

  }


  @GetMapping("")
  @Operation(summary = "Get all users", description = "Caller must be authenticated with the role ADMIN")
  public List<UserWithRolesResponse> getAllUsers() {
    return userWithRolesService.getAllUsers();
  }

  @GetMapping("/{id}")
    public UserWithRolesResponse getUserById(@PathVariable String id) {
        return userWithRolesService.getUserById(id);
  }

  @PutMapping("/{username}")
  public void getUserById(@PathVariable String username, @RequestBody UserWithRolesRequest updatedUser){
    UserWithRoles original = userWithRolesService.getUser(username);
    userWithRolesService.updateUser(original, updatedUser);
  }
}

