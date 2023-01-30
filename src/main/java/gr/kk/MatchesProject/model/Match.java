package gr.kk.MatchesProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gr.kk.MatchesProject.model.validator.MatchValidation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "match")
@DynamicUpdate
@MatchValidation
public class Match implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @NotBlank
    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z]+-[a-zA-Z]+$")
    private String description;
    
    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate match_date;
    
    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime match_time;
    
    @NotNull
    @NotBlank
    @Size(max = 64)
    private String team_a;
    
    @NotNull
    @NotBlank
    @Size(max = 64)
    private String team_b;
    
    @NotNull
    private Sport sport;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, targetEntity = MatchOdds.class, fetch = FetchType.LAZY)
    @JoinColumn(name="match_id", referencedColumnName="id", nullable = false)
    @NotNull
    @JsonUnwrapped
    private Set<MatchOdds> matchodds;

    public Match(int id, String description, LocalDate match_date, LocalTime match_time, String team_a, String team_b, Sport sport, Set<MatchOdds> matchodds) {
        this.id = id;
        this.description = description;
        this.match_date = match_date;
        this.match_time = match_time;
        this.team_a = team_a;
        this.team_b = team_b;
        this.sport = sport;
        this.matchodds = matchodds;
    }
    
    public Match(String description, LocalDate match_date, LocalTime match_time, String team_a, String team_b, Sport sport, Set<MatchOdds> matchodds) {
        this.description = description;
        this.match_date = match_date;
        this.match_time = match_time;
        this.team_a = team_a;
        this.team_b = team_b;
        this.sport = sport;
        this.matchodds = matchodds;
    }
    
    public Match() {}

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getMatch_date() {
        return match_date;
    }

    public LocalTime getMatch_time() {
        return match_time;
    }

    public String getTeam_a() {
        return team_a;
    }

    public String getTeam_b() {
        return team_b;
    }

    public Sport getSport() {
        return sport;
    }

    @JsonIgnore
    public Set<MatchOdds> getMatchOdds() {
        return matchodds;
    }
    
    public enum Sport {
        Football(1),
        Basketball(2);
        
        public final int type;
        
        private Sport(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
        
    }
    
}