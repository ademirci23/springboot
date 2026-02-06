package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.CreateMatiereRequest;
import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.UE;
import be.labil.restapp.domain.mappers.IMatiereMapper;
import be.labil.restapp.repositories.interfaces.IMatiereRepository;
import be.labil.restapp.repositories.interfaces.IUERepository;
import be.labil.restapp.services.interfaces.IMatiereService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class MatiereServiceImpl implements IMatiereService {

    private final IMatiereRepository matiereRepository;
    private final IUERepository ueRepository;
    private final IMatiereMapper matiereMapper;

    @Override
    public MatiereDto create(CreateMatiereRequest req) {
        UE ue = ueRepository.findById(req.getUeId())
                .orElseThrow(() -> new RuntimeException("UE inconnue"));

        Matiere matiere = new Matiere();
        matiere.setCode(req.getCode());
        matiere.setNom(req.getNom());
        matiere.setCredits(req.getCredits());
        matiere.setUe(ue);

        Matiere saved = matiereRepository.save(matiere);
        return matiereMapper.toDto(saved);
    }

    @Override
    public Set<MatiereDto> list() {
        Set<Matiere> entities = new LinkedHashSet<>();
        matiereRepository.findAll().iterator().forEachRemaining(entities::add);
        return matiereMapper.toDto(entities);
    }

    @Override
    public MatiereDto update(Long id, CreateMatiereRequest req) {
        UE ue = ueRepository.findById(req.getUeId())
                .orElseThrow(() -> new RuntimeException("UE inconnue"));

        return matiereRepository.findById(id)
                .map(m -> {
                    m.setCode(req.getCode());
                    m.setNom(req.getNom());
                    m.setCredits(req.getCredits());
                    m.setUe(ue);

                    Matiere saved = matiereRepository.save(m);
                    log.info("Mise à jour Matiere {} OK", saved.getId());
                    return matiereMapper.toDto(saved);
                })
                .orElseThrow(() -> new RuntimeException("Matiere inconnue"));
    }

    @Override
    public boolean delete(Long id) {
        matiereRepository.deleteById(id);
        return true;
    }
}
