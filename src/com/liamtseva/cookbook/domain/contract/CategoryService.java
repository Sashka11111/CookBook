package com.liamtseva.cookbook.domain.contract;

import com.liamtseva.cookbook.persistence.entity.impl.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

  Optional<Category> getCategoryById(int id);

  List<Category> getAllCategories();

  void addCategory(Category category);

  void updateCategory(Category category);

  void deleteCategory(Category category);
}
