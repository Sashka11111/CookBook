package com.liamtseva.cookbook.model;

public class Response {

  private String comment;
  private int mark;
  private User author;
  private int recipesId;

  public Response(String comment, int mark, User author) {
    this.comment = comment;
    this.mark = mark;
    this.author = author;
    this.recipesId = recipesId;
  }

  public Response() {
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) {
    this.mark = mark;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public int getRecipesId() {
    return recipesId;
  }

  public void setRecipesId(int recipesId) {
    this.recipesId = recipesId;
  }

  @Override
  public String toString() {
    return "Response{" +
        "comment='" + comment + '\'' +
        ", mark=" + mark +
        ", author=" + author +
        ", recipesId=" + recipesId +
        '}';
  }
}
