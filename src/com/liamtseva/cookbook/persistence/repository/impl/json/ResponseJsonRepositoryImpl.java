package com.liamtseva.cookbook.persistence.repository.impl.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liamtseva.cookbook.persistence.entity.impl.Response;
import com.liamtseva.cookbook.persistence.entity.impl.User;
import com.liamtseva.cookbook.persistence.repository.contracts.ResponseRepository;
import java.util.Set;
import java.util.stream.Collectors;

class ResponseJsonRepositoryImpl
    extends GenericJsonRepository<Response>
    implements ResponseRepository {

  public ResponseJsonRepositoryImpl(Gson gson) {
    super(gson, JsonPathFactory.RESPONSE.getPath(), TypeToken
        .getParameterized(Set.class, Response.class)
        .getType());
  }

  @Override
  public Set<Response> findAllByAuthor(User author) {
    return entities.stream().filter(c -> c.getAuthor().equals(author))
        .collect(Collectors.toSet());
  }
}
