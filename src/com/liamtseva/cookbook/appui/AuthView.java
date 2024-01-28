package com.liamtseva.cookbook.appui;

import com.liamtseva.cookbook.domain.contract.AuthService;
import com.liamtseva.cookbook.domain.exception.AuthException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthView implements Renderable {

  private final AuthService authService;

  public AuthView(AuthService authService) {
    this.authService = authService;
  }

  @Override
  public void render() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("Книга рецептів");
    System.out.println("1. Авторизація");
    System.out.println("2. Створити обліковий запис");
    System.out.println("3. Вихід");
    System.out.print("Виберіть опцію: ");

    try {
      String input = reader.readLine();
      int choice = Integer.parseInt(input);

      switch (choice) {
        case 1:
          signIn(reader);
          break;
        case 2:
          signUp(reader);
          break;
        case 3:
          System.out.println("Дякую за використання нашої програми. До побачення!");
          break;
        default:
          System.out.println("Невірний вибір. Будь ласка, виберіть знову.");
          render();
          break;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void signIn(BufferedReader reader) throws IOException {
    System.out.println("Введіть ваш логін: ");
    String username = reader.readLine();
    System.out.println("Введіть ваш пароль: ");
    String password = reader.readLine();

    try {
      boolean isAuthenticated = authService.authenticate(username, password);
      if (isAuthenticated) {
        System.out.println("Ви успішно увійшли в систему!");
      } else {
        System.out.println("Невірний логін або пароль. Будь ласка, спробуйте знову.");
      }
    } catch (AuthException e) {
      System.err.println("Помилка автентифікації: " + e.getMessage());
    }
  }

  private void signUp(BufferedReader reader) throws IOException {
    // Логіка для реєстрації нового користувача
    System.out.println("Логіка для реєстрації нового користувача...");
  }
}
