package com.liamtseva.cookbook.domain.contract;

import com.liamtseva.cookbook.persistence.entity.impl.Recipes;
import java.util.List;
import java.util.UUID;

public interface RecipesService {

  Recipes getRecipeById(UUID id);

  List<Recipes> getAllRecipes();

  Recipes addRecipe(Recipes recipe);

  void updateRecipe(Recipes recipe);

  void deleteRecipe(UUID id);
}
