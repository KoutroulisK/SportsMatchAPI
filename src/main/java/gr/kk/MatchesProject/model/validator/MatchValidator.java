package gr.kk.MatchesProject.model.validator;

import gr.kk.MatchesProject.model.Match;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MatchValidator implements ConstraintValidator<MatchValidation, Match> {

    @Override
    public boolean isValid(Match match, ConstraintValidatorContext cvc) {
        String teams[] = match.getDescription().split("-");
        return !(!teams[0].equals(match.getTeam_a()) || !teams[1].equals(match.getTeam_b()));
    }
    
}
