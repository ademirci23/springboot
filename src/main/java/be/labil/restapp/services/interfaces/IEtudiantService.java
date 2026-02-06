package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.EtudiantDto;
import be.labil.restapp.domain.entities.Etudiant;
import java.util.List;
import java.util.Set;

public interface IEtudiantService {

    Etudiant insert(Etudiant etudiant);

    Set<EtudiantDto> list();

    EtudiantDto update(Long id, EtudiantDto etudiantDto);

    Boolean delete(Long id);
}
