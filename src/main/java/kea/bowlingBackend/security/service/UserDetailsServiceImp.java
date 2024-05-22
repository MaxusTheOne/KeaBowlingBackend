package kea.bowlingBackend.security.service;

import kea.bowlingBackend.security.entity.UserWithRoles;
import kea.bowlingBackend.security.repository.UserWithRolesRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

  public static final String WRONG_USERNAME_OR_PASSWORD = "Incorrect username or password";
  private final UserWithRolesRepository userWithRolesRepository;

  public UserDetailsServiceImp(UserWithRolesRepository userWithRolesRepository) {
    this.userWithRolesRepository = userWithRolesRepository;
  }

  @Override
  public UserWithRoles loadUserByUsername(String username) {
    return userWithRolesRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(WRONG_USERNAME_OR_PASSWORD));
  }
}
