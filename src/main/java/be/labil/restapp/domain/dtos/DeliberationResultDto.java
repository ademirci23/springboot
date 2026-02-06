package be.labil.restapp.domain.dtos;

import lombok.Value;
import java.io.Serializable;

@Value
public class DeliberationResultDto implements Serializable {
    Long etudiantId;
    Double moyenne;
    String decision; // "REUSSITE" ou "ECHEC"
}
