package hello;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Userer, Long> {

    List<Userer> findByName(String name);

    List<Userer> findById(Long id);
}
