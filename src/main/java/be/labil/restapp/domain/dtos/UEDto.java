package be.labil.restapp.domain.dtos;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import java.io.Serializable;

@Value
public class UEDto implements Serializable {
    Long id;
    @NotNull(message = "Ce champ ne doit pas être vide")
    String code;
    String nom;
}