package com.liamtseva.cookbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.liamtseva.cookbook.persistence.entity.Entity;
import com.liamtseva.cookbook.persistence.exception.JsonFileIOException;
import com.liamtseva.cookbook.persistence.repository.RepositoryFactory;
import com.liamtseva.cookbook.persistence.repository.contracts.CategoryRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.RecipesRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.ResponseRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.UserRepository;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

/**
 * це реалізація патерну UnitOfWork, та також фабрики з сінглтоном.
 */
public class JsonRepositoryFactory extends RepositoryFactory {

  private final Gson gson;
  private ResponseJsonRepositoryImpl responseJsonRepositoryImpl;
  private RecipesJsonRepositoryImpl recipesJsonRepositoryImpl;
  private CategoryJsonRepositoryImpl categoryJsonRepositoryImpl;
  private UserJsonRepositoryImpl userJsonRepositoryImpl;

  private JsonRepositoryFactory() {
    // Адаптер для типу даних LocalDateTime при серіалізації/десеріалізації
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(LocalDateTime.class,
        (JsonSerializer<LocalDateTime>) (localDate, srcType, context) ->
            new JsonPrimitive(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(localDate)));
    gsonBuilder.registerTypeAdapter(LocalDateTime.class,
        (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
            LocalDateTime.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                    .withLocale(new Locale("uk", "UA"))


    // Адаптер для типу даних LocalDate при серіалізації/десеріалізації
    gsonBuilder.registerTypeAdapter(LocalDate.class,
        (JsonSerializer<LocalDate>) (localDate, srcType, context) ->
            new JsonPrimitive(
                DateTimeFormatter.ofPattern("dd-MM-yyyy").format(localDate)));
    gsonBuilder.registerTypeAdapter(LocalDate.class,
        (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
            LocalDate.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy")
                    .withLocale(Locale.of("uk", "UA"))));

    gson = gsonBuilder.setPrettyPrinting().create();

    responseJsonRepositoryImpl = new ResponseJsonRepositoryImpl(gson);
    recipesJsonRepositoryImpl = new RecipesJsonRepositoryImpl(gson);
    categoryJsonRepositoryImpl = new CategoryJsonRepositoryImpl(gson);
    userJsonRepositoryImpl = new UserJsonRepositoryImpl(gson);
  }

  public static JsonRepositoryFactory getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @Override
  public ResponseRepository getResponseRepository() {
    return responseJsonRepositoryImpl;
  }

  @Override
  public RecipesRepository getResipesRepository() {
    return recipesJsonRepositoryImpl;
  }

  @Override
  public CategoryRepository getCategoryRepository() {
    return categoryJsonRepositoryImpl;
  }

  @Override
  public UserRepository getUserRepository() {
    return userJsonRepositoryImpl;
  }

  public void commit() {
    serializeEntities(responseJsonRepositoryImpl.getPath(), responseJsonRepositoryImpl.findAll());
    serializeEntities(recipesJsonRepositoryImpl.getPath(), recipesJsonRepositoryImpl.findAll());
    serializeEntities(categoryJsonRepositoryImpl.getPath(), categoryJsonRepositoryImpl.findAll());
    serializeEntities(userJsonRepositoryImpl.getPath(), userJsonRepositoryImpl.findAll());
  }

  private <E extends Entity> void serializeEntities(Path path, Set<E> entities) {
    try (FileWriter writer = new FileWriter(path.toFile())) {
      // Скидуємо файлик, перед збереженням!
      writer.write("");
      // Перетворюємо колекцію користувачів в JSON та записуємо у файл
      gson.toJson(entities, writer);

    } catch (IOException e) {
      throw new JsonFileIOException("Не вдалось зберегти дані у json-файл. Детальніше: %s"
          .formatted(e.getMessage()));
    }
  }

  private static class InstanceHolder {

    public static final JsonRepositoryFactory INSTANCE = new JsonRepositoryFactory();
  }
}