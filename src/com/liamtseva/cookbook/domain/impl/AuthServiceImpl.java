package com.liamtseva.cookbook.domain.impl;

import com.liamtseva.cookbook.domain.exception.AuthException;
import com.liamtseva.cookbook.domain.exception.UserAlreadyAuthException;
import com.liamtseva.cookbook.persistence.entity.impl.User;
import com.liamtseva.cookbook.persistence.repository.contracts.UserRepository;
import org.mindrot.bcrypt.BCrypt;

public class AuthServiceImpl {

  private final UserRepository userRepository;
  private User user;

  public AuthServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean authenticate(String username, String password) {
    // Перевіряємо, чи вже існує аутентифікований користувач
    if (user != null) {
      throw new UserAlreadyAuthException("Ви вже авторизувалися як: %s"
          .formatted(user.getUsername()));
    }

    User foundedUser = userRepository.findByUsername(username)
        .orElseThrow(AuthException::new);

    if (!BCrypt.checkpw(password, foundedUser.getPassword())) {
      return false;
    }

    user = foundedUser;
    return true;
  }

  public boolean isAuthenticated() {
    return user != null;
  }

  public User getUser() {
    return user;
  }

  public void logout() {
    if (user == null) {
      throw new UserAlreadyAuthException("Ви ще не автентифікавані.");
    }
    user = null;
  }
}
