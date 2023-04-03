package spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	List<Equipe> findByNomLike(String keyword);
}
