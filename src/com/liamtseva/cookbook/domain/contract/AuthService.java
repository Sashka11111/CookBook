package com.liamtseva.cookbook.domain.contract;

import com.liamtseva.cookbook.persistence.entity.impl.User;

public interface AuthService {

  boolean authenticate(String username, String password);

  boolean isAuthenticated();

  User getUser();

  void logout();
}
