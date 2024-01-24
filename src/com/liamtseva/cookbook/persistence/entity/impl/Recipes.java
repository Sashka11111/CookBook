package com.liamtseva.cookbook.persistence.entity.impl;

import java.util.UUID;

public class Recipes {

  private UUID id;
  private String name;
  private String ingredient;
  private String instruction;
  private int cookingtime;


  public Recipes(UUID id, String name, String ingredient, String instruction, int cookingtime) {
    this.id = id;
    this.name = name;
    this.ingredient = ingredient;
    this.instruction = instruction;
    this.cookingtime = cookingtime;
  }

  public UUID getId() {
    return id;
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

  public String getInstruction() {
    return instruction;
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
        "name='" + name + '\'' +
        ", ingredient='" + ingredient +
        ", instruction=" + instruction + '\'' +
        ", cookingtime=" + cookingtime + '\'' +
        ", id=" + id +
        '}';
  }
}
