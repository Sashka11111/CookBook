package com.liamtseva.cookbook.cookbook;

import com.liamtseva.cookbook.model.User;
import com.liamtseva.cookbook.view.Menu;

public class Application {

  public static User[] users;
  public static User currentUser = new User("sashka", "123456", "sashka@gmail.com",
      "");

  public static void runner() throws IllegalAccessException {
    Menu.show();
  }

  public static void main(String[] args) throws IllegalAccessException {
    String art = " _____             _____ \n"
        + "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\n"
        + "     Welcome to the\n"
        + "      cooking book\n"
        + "|＿＿＿＿＿＿＿＿＿＿＿＿＿＿|\n"
        + "      \\ (•◡•) /\n"
        + "       \\    /\n";

    System.out.println(art);
    runner();
  }
}
