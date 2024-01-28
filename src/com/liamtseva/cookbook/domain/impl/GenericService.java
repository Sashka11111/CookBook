package com.liamtseva.cookbook.domain.impl;

import com.liamtseva.cookbook.persistence.entity.Entity;
import com.liamtseva.cookbook.persistence.repository.Repository;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GenericService<E extends Entity> {

  private final Repository<E> repository;

  public GenericService(Repository<E> repository) {
    this.repository = repository;
  }

  public Optional<E> getById(String id) {
    return repository.findById(id);
  }

  public List<E> getAll() {
    return repository.findAll();
  }

  public List<E> getAllFiltered(Predicate<E> filter) {
    return repository.findAll(filter);
  }

  public void create(E entity) {
    repository.save(entity);
  }

  public void update(E entity) {
    repository.update(entity);
  }

  public void deleteById(String id) {
    repository.deleteById(id);
  }
}
