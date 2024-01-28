package com.liamtseva.cookbook.persistence.entity.impl;

import com.liamtseva.cookbook.persistence.entity.Entity;
import com.liamtseva.cookbook.persistence.entity.ErrorTemplates;
import com.liamtseva.cookbook.persistence.exception.EntityArgumentException;
import java.util.UUID;

public class Response extends Entity {

  private String comment;
  private int mark;
  private User author;
  private UUID recipesid;

  public Response(UUID id, String comment, int mark, User author, UUID recipesid) {
    super(id);
    this.comment = comment;
    this.mark = mark;
    this.author = author;
    this.recipesid = recipesid;
    validateResponse();
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
    validateComment();
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
    validateMark();
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
    validateAuthor();
  }

  public UUID getRecipesid() {
    return recipesid;
  }

  public void setRecipesid(UUID recipesid) {
    this.recipesid = recipesid;
    validateRecipesid();
  }

  private void validateResponse() {
    validateComment();
    validateMark();
    validateAuthor();
    validateRecipesid();

    if (!this.errors.isEmpty()) {
      throw new EntityArgumentException(errors);
    }
  }

  private void validateComment() {
    final String templateName = "Comment";

    if (comment == null || comment.isBlank()) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
  }

  private void validateMark() {
    final String templateName = "Mark";

    if (mark < 1 || mark > 5) {
      errors.add("Рейтинг повинен бути в межах від 1 до 5.");
    }
  }


  private void validateAuthor() {
    final String templateName = "Author";

    if (author == null) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
  }

  private void validateRecipesid() {
    final String templateName = "Recipes ID";

    if (recipesid == null) {
      errors.add(ErrorTemplates.REQUIRED.getTemplate().formatted(templateName));
    }
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
