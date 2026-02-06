package be.labil.restapp.domain.dtos;

import lombok.Value;
import java.io.Serializable;

@Value
public class CreateNoteRequest implements Serializable {
    Integer valeur;
    Long etudiantId;
    Long matiereId;
}
