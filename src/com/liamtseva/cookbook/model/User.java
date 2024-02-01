package com.liamtseva.cookbook.model;

import java.util.UUID;

public class User {

  private String id;
  private String username;
  private String password;
  private String email;
  private String role;

  public User(String username, String password, String email, String role) {
    this.id = UUID.randomUUID().toString();
    this.username = username;
    this.password = password;
    this.email = email;
    this.role = role;
  }

  public User() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}