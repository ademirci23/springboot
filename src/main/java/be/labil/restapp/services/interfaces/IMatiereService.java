package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.CreateMatiereRequest;
import be.labil.restapp.domain.dtos.MatiereDto;

import java.util.Set;

public interface IMatiereService {
    MatiereDto create(CreateMatiereRequest req);
    Set<MatiereDto> list();
    MatiereDto update(Long id, CreateMatiereRequest req);
    boolean delete(Long id);
}
