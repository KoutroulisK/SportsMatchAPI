package gr.kk.MatchesProject.controller;

import gr.kk.MatchesProject.model.Match;
import gr.kk.MatchesProject.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {
    
    @Autowired
    private MatchService matchService;
    
    @PostMapping("/create")
    public ResponseEntity<String> createMatch(@Valid @NonNull @RequestBody Match match) {
        matchService.saveMatch(match);
        return ResponseEntity.ok("Match created");
    }
    
    @GetMapping("/read/{id}")
    public ResponseEntity<Match> readMatch(@PathVariable int id) {
        if(matchService.matchExists(id)) {
            return ResponseEntity.ok(matchService.findMatch(id));
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(null);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateMatch(@Valid @NonNull @RequestBody Match match, @PathVariable int id) {
        if(matchService.matchExists(id)) {
            match.setId(id);
            matchService.saveMatch(match);
            return ResponseEntity.ok("Match updated");
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("Match update failed");
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable int id) {
        if(matchService.matchExists(id)) {
            matchService.deleteMatch(id);
            return ResponseEntity.ok("Match deleted");
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(404)).body("Match deletion failed");
    }
    
}
