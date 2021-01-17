package library.repository;

import library.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, Long> {
    User findByName(String username);
}
