package com.liamtseva.cookbook.persistence.repository;

import com.liamtseva.cookbook.persistence.entity.Entity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface Repository<E extends Entity> {

  Optional<E> findById(UUID id); // Змінено сигнатуру методу findById

  List<E> findAll();

  List<E> findAll(Predicate<E> filter);

  E save(E entity);

  void update(E entity);

  void deleteById(UUID id); // Змінено сигнатуру методу deleteById
}
