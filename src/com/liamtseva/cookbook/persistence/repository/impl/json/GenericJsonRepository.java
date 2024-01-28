package com.liamtseva.cookbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.liamtseva.cookbook.persistence.entity.Entity;
import com.liamtseva.cookbook.persistence.repository.Repository;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class GenericJsonRepository<E extends Entity> implements Repository<E> {

  private final List<E> entities;
  private final Gson gson;
  private final Path path;
  private final Type collectionType;

  public GenericJsonRepository(Gson gson, Path path, Type collectionType) {
    this.gson = gson;
    this.path = path;
    this.collectionType = collectionType;
    entities = new ArrayList<>(loadAll());
  }

  @Override
  public E findById(UUID id) {
    return entities.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
  }

  @Override
  public List<E> findAll() {
    return entities;
  }

  @Override
  public List<E> findAll(Predicate<E> filter) {
    return entities.stream().filter(filter).toList();
  }

  @Override
  public E add(E entity) {
    entities.add(entity);
    saveAll();
    return entity;
  }

  @Override
  public E remove(E entity) {
    entities.remove(entity);
    saveAll();
    return entity;
  }

  @Override
  public E remove(UUID id) {
    E entityToRemove = findById(id);
    if (entityToRemove != null) {
      entities.remove(entityToRemove);
      saveAll();
    }
    return entityToRemove;
  }

  private void saveAll() {
    // Код для збереження всіх сутностей у файлі
  }

  private List<E> loadAll() {
    // Код для завантаження всіх сутностей з файлу
    return new ArrayList<>(); // Приклад
  }
}

