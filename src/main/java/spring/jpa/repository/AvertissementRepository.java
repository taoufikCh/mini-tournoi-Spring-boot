package spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.Avertissement;

public interface AvertissementRepository extends JpaRepository<Avertissement, Long> {
}
