package com.liamtseva.cookbook.model;

public class Recipes {

  private int recipesId;
  private String category;
  private String name;
  private String ingredient;
  private String instruction;
  private int cookingTime;

  public Recipes(int recipesId, String category, String name, String ingredient, String instruction,
      int cookingTime) {
    this.recipesId = recipesId;
    this.category = category;
    this.name = name;
    this.ingredient = ingredient;
    this.instruction = instruction;
    this.cookingTime = cookingTime;
  }

  public Recipes(String name, String ingredients, String category, String instruction,
      int cookingTime) {

  }

  public Recipes() {
  }

  public int getRecipesId() {
    return recipesId;
  }

  public void setRecipesId(int recipesId) {
    this.recipesId = recipesId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIngredient() {
    return ingredient;
  }

  public void setIngredient(String ingredient) {
    this.ingredient = ingredient;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  public int getCookingTime() {
    return cookingTime;
  }

  public void setCookingTime(int cookingTime) {
    this.cookingTime = cookingTime;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Recipes{" +
        "recipesId=" + recipesId +
        ", name='" + name + '\'' +
        ", category='" + category + '\'' +
        ", ingredient='" + ingredient + '\'' +
        ", instruction='" + instruction + '\'' +
        ", cookingTime=" + cookingTime +
        '}';
  }
}
