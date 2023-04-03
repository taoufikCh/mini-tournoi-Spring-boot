package spring.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import spring.jpa.model.Pays;


public interface PaysRepository extends JpaRepository<Pays, Long>{
	
	List<Pays> findByNomLike(String keyword);
	//Page<Pays> findByNomLike(String keyword, Pageable pageable);
	Page<Pays> findByNomContaining(String nom, Pageable pageable);

}
