package com.liamtseva.cookbook.persistence.repository.contracts;

import com.liamtseva.cookbook.persistence.entity.impl.User;
import com.liamtseva.cookbook.persistence.repository.Repository;
import java.util.Optional;

/**
 * Ми визначаємо з яким ентіті працювати (убираємо дженерік). Ми додаємо "кастомні" методі, які
 * актульні лише для цієї сутності!
 */
public interface UserRepository extends Repository<User> {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);
}