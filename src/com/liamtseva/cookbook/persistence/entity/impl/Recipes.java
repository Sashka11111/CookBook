package com.liamtseva.cookbook.persistence.entity.impl;

import com.liamtseva.cookbook.persistence.entity.Entity;
import java.util.UUID;

public class Recipes extends Entity {

  private String name;
  private String ingredient;
  private String instruction;
  private int cookingtime;

  public Recipes(UUID id, String name, String ingredient, String instruction, int cookingtime) {
    super(id);
    this.name = name;
    this.ingredient = ingredient;
    this.instruction = instruction;
    this.cookingtime = cookingtime;
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

  public int getCookingtime() {
    return cookingtime;
  }

  public void setCookingtime(int cookingtime) {
    this.cookingtime = cookingtime;
  }

  @Override
  public String toString() {
    return "Recipes{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", ingredient='" + ingredient + '\'' +
        ", instruction='" + instruction + '\'' +
        ", cookingtime=" + cookingtime +
        '}';
  }
}
