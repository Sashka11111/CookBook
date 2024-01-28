package com.liamtseva.cookbook.domain.impl;

import com.liamtseva.cookbook.persistence.entity.impl.Category;
import com.liamtseva.cookbook.persistence.repository.contracts.CategoryRepository;
import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Optional<Category> getCategoryById(int id) {
    return categoryRepository.findById(id);
  }

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public void addCategory(Category category) {
    categoryRepository.add(category);
  }

  public void updateCategory(Category category) {
    categoryRepository.update(category);
  }

  public void deleteCategory(Category category) {
    categoryRepository.remove(category);
  }
}
