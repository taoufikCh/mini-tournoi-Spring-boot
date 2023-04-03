package spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.jpa.model.Equipe;
import spring.jpa.model.Joueur;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	List<Joueur> findByNomLike(String keyword);
	List<Joueur> findByEquipeLike(Equipe equipe);
}
