package com.liamtseva.cookbook.domain.impl;

import com.liamtseva.cookbook.domain.contract.AuthService;

public class ServiceFactory {

  // Єдиний екземпляр класу ServiceFactory
  private static final ServiceFactory instance = new ServiceFactory();

  // Приватний конструктор, щоб заборонити створення нових екземплярів
  private ServiceFactory() {
    // Виконайте ініціалізацію тут, якщо необхідно
  }

  // Метод для отримання єдиного екземпляра класу ServiceFactory
  public static ServiceFactory getInstance() {
    return instance;
  }

  // Метод для отримання AuthService
  public AuthService getAuthService() {
    // Додайте код для створення та повернення AuthService
    // Наприклад:
    // return new AuthServiceImpl();
    return null; // Покищо повертаємо null
  }

  // Додаткові методи класу ServiceFactory можна додавати тут
}
