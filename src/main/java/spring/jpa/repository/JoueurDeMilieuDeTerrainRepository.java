package spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.jpa.model.Equipe;

import spring.jpa.model.JoueurDeMilieuDeTerrain;

public interface JoueurDeMilieuDeTerrainRepository extends JpaRepository<JoueurDeMilieuDeTerrain, Long>{
	List<JoueurDeMilieuDeTerrain> findByEquipeLike(Equipe equipe);

}
