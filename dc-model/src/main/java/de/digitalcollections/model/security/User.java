package de.digitalcollections.model.security;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.springframework.util.StringUtils;

/** An user of the system. */
public class User {

  @NotBlank @Email private String email;

  private boolean enabled = true;

  @NotBlank private String firstname;

  private Long id;

  @NotBlank private String lastname;

  private String passwordHash;

  private List<Role> roles = new ArrayList<>();

  private UUID uuid;

  public User() {}

  public String getEmail() {
    return email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public List<Role> getRoles() {
    return this.roles;
  }

  public UUID getUuid() {
    return uuid;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Sets password hash if password hash is not empty, otherwise no operation. Deleting of password
   * is not possible.
   *
   * @param passwordHash new hashed password
   */
  public void setPasswordHash(String passwordHash) {
    if (!StringUtils.isEmpty(passwordHash)) {
      this.passwordHash = passwordHash;
    }
  }

  public void setRoles(List<Role> userRoles) {
    this.roles = userRoles;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }
}
