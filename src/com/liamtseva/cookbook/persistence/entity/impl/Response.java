package com.liamtseva.cookbook.persistence.entity.impl;

import com.liamtseva.cookbook.persistence.entity.Entity;
import java.util.UUID;

public class Response extends Entity {

  private String comment;
  private String mark;
  private User author;
  private Recipes recipesid;

  public Response(UUID id, String comment, String mark, User author, Recipes recipesid) {
    super(id);
    this.comment = comment;
    this.mark = mark;
    this.author = author;
    this.recipesid = recipesid;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Recipes getRecipesid() {
    return recipesid;
  }

  public void setRecipesid(Recipes recipesid) {
    this.recipesid = recipesid;
  }


  @Override
  public String toString() {
    return "Response{" +
        "comment='" + comment + '\'' +
        ", mark='" + mark +
        ", author=" + author + '\'' +
        ", recipesid=" + recipesid + '\'' +
        ", id=" + id +
        '}';
  }
}
