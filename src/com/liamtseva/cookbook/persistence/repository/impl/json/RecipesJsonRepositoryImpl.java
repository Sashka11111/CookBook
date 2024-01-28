package com.liamtseva.cookbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liamtseva.cookbook.persistence.entity.impl.Recipes;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * JSON implementation of the Recipe repository.
 */
public class RecipesJsonRepositoryImpl extends GenericJsonRepository<Recipes> implements
    RecipesRepository {

  /**
   * Constructs a new instance of {@code RecipeJsonRepositoryImpl}.
   *
   * @param gson The Gson instance for JSON serialization/deserialization.
   */
  public RecipesJsonRepositoryImpl(Gson gson) {
    super(gson, JsonPathFactory.RECIPES.getPath(), new TypeToken<Set<Recipes>>() {
    }.getType());
  }

  /**
   * Finds all recipes in a specific category.
   *
   * @param categoryId The ID of the category.
   * @return A set of recipes in the specified category.
   */
  @Override
  public Set<Recipes> findAllByCategory(String categoryId) {
    return entities.stream()
        .filter(recipe -> categoryId.equals(recipe.getCategory().getId().toString()))
        .collect(Collectors.toSet());
  }

  /**
   * Finds all recipes by a specific author.
   *
   * @param authorId The ID of the author.
   * @return A set of recipes written by the specified author.
   */
  @Override
  public Set<Recipe> findAllByAuthor(String authorId) {
    return entities.stream()
        .filter(recipe -> authorId.equals(recipe.getAuthor()))
        .collect(Collectors.toSet());
  }

  /**
   * Finds all available recipes.
   *
   * @return A set of available recipes.
   */
  @Override
  public Set<Recipes> findAllAvailable() {
    return entities.stream()
        .filter(Recipes::isAvailable)
        .collect(Collectors.toSet());
  }
}
