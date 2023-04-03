package spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.Entraineur;

public interface EntraineurRepository extends JpaRepository<Entraineur, Long> {
	
	List<Entraineur> findByNomOrPrenomLike(String keyword, String keyword1);

}
