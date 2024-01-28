package com.liamtseva.cookbook.domain.exception;

public class AuthException extends RuntimeException {

  public AuthException() {
    super("Не вірний логін чи пароль.");
  }
}
