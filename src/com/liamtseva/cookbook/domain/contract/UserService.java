package com.liamtseva.cookbook.domain.contract;

import com.liamtseva.cookbook.domain.Service;
import com.liamtseva.cookbook.domain.dto.UserAddDto;
import com.liamtseva.cookbook.persistence.entity.impl.User;

public interface UserService extends Service<User> {

  User getByUsername(String username);

  User getByEmail(String email);

  User add(UserAddDto userAddDto);
}

