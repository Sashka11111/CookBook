package com.liamtseva.cookbook.persistence.repository.contracts;

import com.liamtseva.cookbook.persistence.entity.impl.Response;
import com.liamtseva.cookbook.persistence.entity.impl.User;
import com.liamtseva.cookbook.persistence.repository.Repository;
import java.util.Set;

public interface ResponseRepository extends Repository<Response> {

  Set<Response> findAllByAuthor(User author);
}
