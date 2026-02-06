package be.labil.restapp.domain.dtos;

import lombok.Value;
import java.io.Serializable;

@Value
public class CreateMatiereRequest implements Serializable {
    String code;
    String nom;
    Integer credits;
    Long ueId;
}
