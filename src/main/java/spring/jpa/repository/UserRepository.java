package spring.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByUsernameLike(String keyword);
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
