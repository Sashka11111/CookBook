package com.liamtseva.cookbook.persistence.repository.impl.json;

import java.nio.file.Path;

/**
 * Фабрика об'єктів Path для DAO.
 */
enum JsonPathFactory {
  USERS("users.json"),
  RESPONSE("response.json"),
  CATEGORY("category.json"),
  RESIPES("resipes.json");

  private static final String DATA_DIRECTORY = "data";
  private final String fileName;

  JsonPathFactory(String fileName) {
    this.fileName = fileName;
  }

  public Path getPath() {
    return Path.of(DATA_DIRECTORY, this.fileName);
  }
}
