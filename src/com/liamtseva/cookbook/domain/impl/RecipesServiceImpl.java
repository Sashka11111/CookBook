package com.liamtseva.cookbook.domain.impl;

import com.liamtseva.cookbook.domain.contract.RecipesService;
import com.liamtseva.cookbook.persistence.entity.impl.Recipes;
import com.liamtseva.cookbook.persistence.repository.contracts.RecipesRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RecipesServiceImpl implements RecipesService {

  private final RecipesRepository recipeRepository;

  public RecipesServiceImpl(RecipesRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  @Override
  public Recipes getRecipeById(UUID id) {
    Optional<Recipes> optionalRecipes = recipeRepository.findById(id);
    return optionalRecipes.orElse(
        null); // Виберіть значення з Optional або поверніть null, якщо немає значення
  }

  @Override
  public List<Recipes> getAllRecipes() {
    return recipeRepository.findAll();
  }

  @Override
  public Recipes addRecipe(Recipes recipe) {
    return recipeRepository.save(recipe);
  }

  @Override
  public void updateRecipe(Recipes recipe) {
    recipeRepository.update(recipe);
  }

  @Override
  public void deleteRecipe(UUID id) {
    recipeRepository.deleteById(id);
  }
}
