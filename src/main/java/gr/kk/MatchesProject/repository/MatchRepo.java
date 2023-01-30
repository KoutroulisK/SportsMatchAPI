package gr.kk.MatchesProject.repository;

import gr.kk.MatchesProject.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepo extends JpaRepository<Match, Integer> {
}
