package pl.nullpointerexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nullpointerexception.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
