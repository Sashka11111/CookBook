package com.liamtseva.cookbook.domain.dto;

import com.liamtseva.cookbook.persistence.entity.Entity;
import com.liamtseva.cookbook.persistence.entity.ErrorTemplates;
import com.liamtseva.cookbook.persistence.entity.impl.User.Role;
import com.liamtseva.cookbook.persistence.exception.EntityArgumentException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public final class UserAddDto extends Entity {

  private final String username;
  private final String rawPassword;
  private final String email;
  private final String avatarPath;
  private final Role role;

  public UserAddDto(UUID id,
      String username,
      String rawPassword,
      String email,
      String avatarPath) {
    super(id);
    this.username = username;
    this.rawPassword = validatedPassword(rawPassword);
    this.email = email;
    this.avatarPath = avatarPath;
    this.role = Role.GENERAL;
  }

  public UserAddDto(UUID id,
      String username,
      String rawPassword,
      String email,
      String avatarPath,
      Role role) {
    super(id);
    this.username = username;
    this.rawPassword = validatedPassword(rawPassword);
    this.email = email;
    this.avatarPath = avatarPath;
    this.role = role;
  }

  private String validatedPassword(String rawPassword) {
    final String templateName = "паролю";
    List<String> errors = new ArrayList<>();

    if (rawPassword.isBlank()) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
    if (rawPassword.length() < 8) {
      errors.add(ErrorTemplates.MIN_LENGTH.getTemplate().formatted(templateName, 8));
    }
    if (rawPassword.length() > 32) {
      errors.add(ErrorTemplates.MAX_LENGTH.getTemplate().formatted(templateName, 32));
    }
    var pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$");
    if (!pattern.matcher(rawPassword).matches()) {
      errors.add(ErrorTemplates.PASSWORD.getTemplate().formatted(templateName, 8));
    }

    if (!errors.isEmpty()) {
      throw new EntityArgumentException(errors);
    }

    return rawPassword;
  }

  public String getUsername() {
    return username;
  }

  public String getRawPassword() {
    return rawPassword;
  }

  public String getEmail() {
    return email;
  }

  public String getAvatarPath() {
    return avatarPath;
  }

  public Role getRole() {
    return role;
  }
}
