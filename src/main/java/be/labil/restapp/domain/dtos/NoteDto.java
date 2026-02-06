package be.labil.restapp.domain.dtos;

import lombok.Value;
import java.io.Serializable;

@Value
public class NoteDto implements Serializable {
    Long id;
    Integer valeur;
    Long etudiantId;
    Long matiereId;
}
