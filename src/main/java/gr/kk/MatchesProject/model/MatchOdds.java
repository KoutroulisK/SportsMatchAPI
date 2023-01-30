package gr.kk.MatchesProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "matchodds")
public class MatchOdds implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Pattern(regexp = "^1|X|2$")
    private String specifier;
    
    @NotNull
    @Digits(integer=4, fraction=2)
    private float odd;
    
    public MatchOdds(int id, String specifier, float odd) {
        this.id = id;
        this.specifier = specifier;
        this.odd = odd;
    }
    
    public MatchOdds() {}

    public int getId() {
        return id;
    }
    
    public String getSpecifier() {
        return specifier;
    }

    public float getOdd() {
        return odd;
    }
    
}