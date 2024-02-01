package com.liamtseva.cookbook.view;

import com.liamtseva.cookbook.cookbook.Application;
import com.liamtseva.cookbook.service.AuthorizationService;
import com.liamtseva.cookbook.service.CategoryService;
import com.liamtseva.cookbook.service.EditService;
import com.liamtseva.cookbook.service.RecipesService;
import com.liamtseva.cookbook.service.RegistrationService;
import com.liamtseva.cookbook.service.ResponseService;
import com.liamtseva.cookbook.service.SearchService;
import com.liamtseva.cookbook.service.UserService;

public class Menu {

  public Menu() {
  }

  public static void show() throws IllegalAccessException {
    UserInputHandler userInputHandler = new UserInputHandler();
    while (true) {
      String userRole = Application.currentUser.getRole();

      if ("".equals(userRole)) {
        System.out.println("1) Реєстрація");
        System.out.println("2) Авторизація");
      } else {
        String art = "    (\\\n"
            + "     \\ \\\n"
            + " __    \\/ ___,.-------..__        __\n"
            + "//\\\\ _,-'\\\\               `'--._ //\\\\\n"
            + "\\\\ ;'      \\\\                   `: //\n"
            + " `(          \\\\                   )'\n"
            + "   :.          \\\\,----,         ,;\n"
            + "    `.`--.___   (    /  ___.--','\n"
            + "      `.     ``-----'-''     ,'\n"
            + "         -.               ,-\n"
            + "            `-._______.-'\n";
        System.out.println(art);
        System.out.println("1) Вийти з головного меню");
        System.out.println("2) Перегляд даних");
        System.out.println("3) Пошук рецептів");

        if ("Адмін".equals(userRole)) {
          System.out.println("4) Додавання даних");
          System.out.println("5) Редагування даних");
        }
      }

      System.out.println("0) Вихід");

      int choice = userInputHandler.promptUserForInteger("Ваш вибір");

      switch (choice) {
        case 1:
          if ("".equals(userRole)) {
            // реєстрація
            RegistrationService.registration();
          } else {
            Application.currentUser.setRole("");
            show();
          }
          break;
        case 2:
          if ("".equals(userRole)) {
            // Авторизація
            AuthorizationService.authorization();
          } else {
            System.out.println("1) Переглянути рецепти");
            System.out.println("2) Переглянути категорії");
            System.out.println("3) Переглянути відгуки");
            System.out.println("4) Переглянути мої дані");
            System.out.println("5) Повернення в головне меню");

            int choicePoint = new UserInputHandler().promptUserForInteger(
                "Ваш вибір"); // вибір користувача
            switch (choicePoint) {
              case 1: {
                String[] args = {};
                RecipesService.main(args);
                break;
              }
              case 2: {
                String[] args = {};
                CategoryService.main(args);
                break;
              }
              case 3: {
                String[] args = {};
                ResponseService.main(args);
                break;
              }
              case 4: {
                UserConsoleUI.displayUserInfo(Application.currentUser);
              }
              case 5: {
                show();
              }
              default: {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
              }
            }
            break;
          }
        case 3:
          if ("".equals(userRole)) {
            break;
          } else {
            SearchService.searchService();
            break;
          }
        case 4:
          if ("".equals(userRole)) {
            break;
          } else {
            System.out.println("1) Додати рецепт");
            System.out.println("2) Додати відгук");
            System.out.println("3) Вихід");

            int choicePoint = new UserInputHandler().promptUserForInteger(
                "Ваш вибір"); // вибір користувача
            switch (choicePoint) {
              case 1: {
                RecipesService.addRecipe();
                break;
              }
              case 2: {
                ResponseService.addResponse();
                break;
              }
              case 3: {
                show();
              }
              default: {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
              }
            }
            break;
          }

        case 5:
          if ("".equals(userRole)) {
            break;
          } else {
            //Редагування
            System.out.println("1) Редагувати рецепт");
            System.out.println("2) Редагувати дані користувача");
            System.out.println("3) Вихід");

            int choicePoint = new UserInputHandler().promptUserForInteger(
                "Ваш вибір"); // вибір користувача
            switch (choicePoint) {
              case 1: {
                EditService.editRecipe();
                break;
              }
              case 2: {
                UserService.updateUserInMenu();
                break;
              }
              case 3: {
                show();
              }
              default: {
                System.out.println("Невірний вибір. Спробуйте ще раз.");
                break;
              }
            }
          }
          break;
        case 0:
          // Вихід
          System.out.println("Дякую за використання.");
          System.exit(0);
          break;
        default:
          System.out.println("Невірний вибір. Спробуйте ще раз.");
          break;
      }
    }
  }
}

