import com.liamtseva.cookbook.domain.contract.ResponseService;
import com.liamtseva.cookbook.domain.exception.EntityNotFoundException;
import com.liamtseva.cookbook.persistence.entity.impl.Response;
import com.liamtseva.cookbook.persistence.repository.contracts.ResponseRepository;
import com.liamtseva.cookbook.persistence.repository.contracts.UserRepository;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ResponseServiceImpl
    extends GenericService<Response>
    implements ResponseService {

  private final ResponseRepository responseRepository;
  private final UserRepository userRepository;

  public ResponseServiceImpl(ResponseRepository responseRepository, UserRepository userRepository) {
    super(responseRepository);
    this.responseRepository = responseRepository;
    this.userRepository = userRepository;
  }

  @Override
  public void add(Response response) {
    // Додайте код для додавання об'єкта типу Response до репозиторію
    responseRepository.add(response);
  }

  @Override
  public Response get(UUID id) {
    // Додайте код для отримання об'єкта типу Response за його ідентифікатором id
    return null; // Покищо повертаємо null
  }

  @Override
  public Set<Response> findAllByAuthor(String username) {
    User author = userRepository.findByUsername(username)
        .orElseThrow(() -> new EntityNotFoundException("Такого автора відгуку не існує"));
    return responseRepository.findAllByAuthor(author);
  }

  @Override
  public Set<Response> getAll() {
    return getAll(c -> true);
  }

  @Override
  public Set<Response> getAll(Predicate<Response> filter) {
    return responseRepository.findAll(filter).stream()
        .sorted(Comparator.comparing(Response::getCreatedAt).reversed())
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }
}
