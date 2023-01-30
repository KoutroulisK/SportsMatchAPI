package gr.kk.MatchesProject.service;

import gr.kk.MatchesProject.model.Match;
import gr.kk.MatchesProject.repository.MatchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {
    
    @Autowired
    private MatchRepo matchRepo;

    @Override
    public void saveMatch(Match match) {
        matchRepo.save(match);
    }

    @Override
    public Match findMatch(int id) {
        return matchRepo.findById(id).get();
    }

    @Override
    public void deleteMatch(int id) {
        matchRepo.deleteById(id);
    }

    @Override
    public Boolean matchExists(int id) {
        return matchRepo.existsById(id);
    }
    
}
