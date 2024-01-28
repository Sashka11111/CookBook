package com.liamtseva.cookbook.domain.contract;

import com.liamtseva.cookbook.domain.dto.UserAddDto;
import java.util.function.Supplier;

public interface SignUpService {

  void signUp(UserAddDto userAddDto, Supplier<String> waitForUserInput);
}
