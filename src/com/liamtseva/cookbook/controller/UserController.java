package com.liamtseva.cookbook.controller;

import com.liamtseva.cookbook.model.User;
import com.liamtseva.cookbook.service.UserService;
import java.util.List;

public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  // Метод для створення нового користувача
  public void createUser(String username, String password, String email, String role) {
    User newUser = new User(username, password, email, role);
    userService.createUser(newUser);
    System.out.println("Користувач " + username + " успішно створений.");
  }

  // Метод для отримання списку всіх користувачів
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  // Метод для отримання користувача за ідентифікатором
  public User getUserById(long userId) {
    return userService.getUserById(userId);
  }

  // Метод для оновлення інформації про користувача
  public void updateUser(long userId, String newPassword, String newEmail) {
    User userToUpdate = userService.getUserById(userId);
    if (userToUpdate != null) {
      userToUpdate.setPassword(newPassword);
      userToUpdate.setEmail(newEmail);
      userService.updateUser(userToUpdate);
      System.out.println("Інформацію про користувача " + userId + " успішно оновлено.");
    } else {
      System.out.println("Користувача з ідентифікатором " + userId + " не знайдено.");
    }
  }
}