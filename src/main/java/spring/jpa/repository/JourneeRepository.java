package spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.Journee;

public interface JourneeRepository extends JpaRepository<Journee, Long> {
}
