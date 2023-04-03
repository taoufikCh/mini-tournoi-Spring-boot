package spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.Tournoi;

public interface TournoiRepository extends JpaRepository<Tournoi, Long> {
}
