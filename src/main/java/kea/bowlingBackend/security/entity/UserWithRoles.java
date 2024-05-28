package kea.bowlingBackend.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import kea.bowlingBackend.security.repository.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.ResponseStatusException;

@Configurable
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR_TYPE")
public class UserWithRoles implements UserDetails {

  @Transient
  static final int PASSWORD_MIN_LENGTH = 60; // BCrypt encoded passwords always have length 60

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Column(name = "user_id")
  private Long userId;

  @Column(nullable = false, length = 50, unique = true)
  private String username;

  @Column(nullable = false, length = 50, unique = true)
  private String email;

  //60 = length of a bcrypt encoded password
  @JsonIgnore
  @Column(nullable = false, length = 60)
  private String password;

  private boolean enabled = true;

  @CreationTimestamp
  private LocalDateTime created;

  @UpdateTimestamp
  private LocalDateTime edited;

  @Getter
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "user_roles",
    joinColumns = {
      @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
    },
    inverseJoinColumns = {
      @JoinColumn(name = "role_roleName", referencedColumnName = "roleName"),
    }
  )
  private Set<Role> roles = new HashSet<>();

  public UserWithRoles() {}

  public UserWithRoles(String username, String password, String email) {
    this.username = username;
    setPassword(password);
    this.email = email;
  }
  public UserWithRoles(String username, String email, Set<Role> roleEntities, LocalDateTime created, LocalDateTime edited) {
    this.username = username;
    this.email = email;
    this.roles = roleEntities;
    this.created = created;
    this.edited = edited;
  }


  public UserWithRoles(String username, String password, String email, Set<Role> roleEntities, LocalDateTime created, LocalDateTime edited) {
    this.username = username;
    setPassword(password);
    this.email = email;
    this.roles = roleEntities;
    this.created = created;
    this.edited = edited;
  }


  public void setPassword(String password) {
    if (password.length() < PASSWORD_MIN_LENGTH) {
      throw new IllegalArgumentException("Password is not encoded");
    }
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles
      .stream()
      .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
      .collect(Collectors.toSet());
  }

  public void addRole(Role roleToAdd) {
    if (!roles.contains(roleToAdd)) {
      roles.add(roleToAdd);
      roleToAdd.addUser(this);
    }
  }

  public void removeRole(Role roleToRemove) {
    if (roles.contains(roleToRemove)) {
      roles.remove(roleToRemove);
    }
  }

  public String getName() {
    return username;
  }

  public String getUsername() {
    return username;
  }

  //You can, but are NOT expected to use the fields below
  @Override
  public boolean isAccountNonExpired() {
    return enabled;
  }

  @Override
  public boolean isAccountNonLocked() {
    return enabled;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return enabled;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
