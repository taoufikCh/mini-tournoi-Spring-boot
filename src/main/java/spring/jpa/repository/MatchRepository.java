package spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.jpa.model.MatchFoot;

public interface MatchRepository extends JpaRepository<MatchFoot, Long> {

}
