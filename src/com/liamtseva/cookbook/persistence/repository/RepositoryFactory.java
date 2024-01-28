package com.liamtseva.cookbook.persistence.repository;

import com.liamtseva.cookbook.persistence.repository.contracts.CategoryRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.RecipesRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.ResponseRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.UserRepository;
import com.liamtseva.cookbook.persistence.repository.impl.json.JsonRepositoryFactory;
import org.apache.commons.lang3.NotImplementedException;

public abstract class RepositoryFactory {

  public static final int JSON = 1;
  public static final int XML = 2;
  public static final int POSTGRESQL = 3;

  public static RepositoryFactory getRepositoryFactory(int whichFactory) {
    return switch (whichFactory) {
      case JSON -> JsonRepositoryFactory.getInstance();
      case XML -> throw new NotImplementedException("Робота з XML файлами не реалізована.");
      case POSTGRESQL -> throw new NotImplementedException(
          "Робота з СУБД PostgreSQL не реалізована.");
      default -> throw new IllegalArgumentException(
          "Помилка при виборі фабрики репозиторіїв.");
    };
  }

  public abstract ResponseRepository getResponseRepository();

  public abstract RecipesRepository getResipesRepository();

  public abstract CategoryRepository getCategoryRepository();

  public abstract UserRepository getUserRepository();

  public abstract void commit();
}
