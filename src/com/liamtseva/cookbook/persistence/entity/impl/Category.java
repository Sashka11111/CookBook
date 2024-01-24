package com.liamtseva.cookbook.persistence.entity.impl;

import com.liamtseva.cookbook.persistence.entity.Entity;
import java.util.UUID;

public class Category extends Entity {

  private String name;

  public Category(UUID id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Category{" +
        "name='" + name + '\'' +
        ", id=" + id +
        '}';
  }
}
