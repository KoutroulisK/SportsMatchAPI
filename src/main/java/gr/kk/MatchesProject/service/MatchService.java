package gr.kk.MatchesProject.service;

import gr.kk.MatchesProject.model.Match;

public interface MatchService {
    
    public void saveMatch(Match match);
    
    public Match findMatch(int id);
    
    public void deleteMatch(int id);
    
    public Boolean matchExists(int id);
}
