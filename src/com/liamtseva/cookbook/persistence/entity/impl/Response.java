package com.liamtseva.cookbook.persistence.entity.impl;

import com.liamtseva.cookbook.persistence.entity.Entity;
import java.util.UUID;

/**
 * TODO: зробити валідацію по аналогії з User
 */
public class Response extends Entity {

  private String body;
  private String mark;
  private User author;

  public Response(UUID id, String body, String mark, User author) {
    super(id);
    this.body = body;
    this.mark = mark;
    this.author = author;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
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


  @Override
  public String toString() {
    return "Comment{" +
        "body='" + body + '\'' +
        ", author=" + author +
        ", mark='" + mark + '\'' +
        ", id=" + id +
        '}';
  }
}
