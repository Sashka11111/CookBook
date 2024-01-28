package com.liamtseva.cookbook.persistence.repository.contracts;

import com.liamtseva.cookbook.persistence.entity.impl.Category;
import com.liamtseva.cookbook.persistence.repository.Repository;
import java.util.Set;

public interface CategoryRepository extends Repository<Category> {

  Set<Category> findAllByName(String categoryName);

  void update(Category category);
}



