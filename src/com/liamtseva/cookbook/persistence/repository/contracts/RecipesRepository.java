package com.liamtseva.cookbook.persistence.repository.contracts;

import com.liamtseva.cookbook.persistence.entity.impl.Recipes;
import com.liamtseva.cookbook.persistence.repository.Repository;
import java.util.Set;

public interface RecipesRepository extends Repository<Recipes> {

  Set<Recipes> findAllByCategory(String categoryId);

  Set<Recipes> findAllByAuthor(String authorId);

  Set<Recipes> findAllAvailable();

  void addRecipe(Recipes recipe);

  void updateRecipe(Recipes recipe);

  void deleteRecipe(Recipes recipe);
}

