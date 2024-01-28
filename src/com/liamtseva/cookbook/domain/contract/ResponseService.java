package com.liamtseva.cookbook.domain.contract;

import com.liamtseva.cookbook.persistence.entity.impl.Response;
import java.util.List;

public interface ResponseService {

  /**
   * Отримати список усіх відгуків.
   *
   * @return список усіх відгуків
   */
  List<Response> getAllResponses();

  /**
   * Додати відгук.
   *
   * @param response відгук, який потрібно додати
   */
  void addResponse(Response response);

  /**
   * Оновити відгук.
   *
   * @param response відгук, який потрібно оновити
   */
  void updateResponse(Response response);

  /**
   * Видалити відгук.
   *
   * @param response відгук, який потрібно видалити
   */
  void deleteResponse(Response response);
}
