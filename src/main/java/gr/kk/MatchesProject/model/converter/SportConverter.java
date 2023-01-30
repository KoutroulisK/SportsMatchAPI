package gr.kk.MatchesProject.model.converter;

import gr.kk.MatchesProject.model.Match.Sport;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SportConverter implements AttributeConverter<Sport, Integer> {
    
    @Override
    public Integer convertToDatabaseColumn(Sport sport) {
        if (sport == null) {
            return 0;
        }
        return sport.getType();
    }

    @Override
    public Sport convertToEntityAttribute(Integer type) {
        if (type == null) {
            return null;
        }

        return Stream.of(Sport.values())
          .filter(c -> c.getType() == type)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
    
}
