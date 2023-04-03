package spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.jpa.model.Equipe;
import spring.jpa.model.GardienDeBut;


public interface GardienDeButRepository extends JpaRepository<GardienDeBut, Long> {
	List<GardienDeBut> findByEquipeLike(Equipe equipe);

}
