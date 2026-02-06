package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.UEDto;
import be.labil.restapp.domain.entities.UE;
import be.labil.restapp.domain.mappers.IUEMapper;
import be.labil.restapp.repositories.interfaces.IUERepository;
import be.labil.restapp.services.interfaces.IUEService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class UEServiceImpl implements IUEService {

    private final IUERepository ueRepository;
    private final IUEMapper ueMapper;

    @Override
    public UEDto create(UEDto dto) {
        UE entity = ueMapper.toEntity(dto);
        UE saved = ueRepository.save(entity);
        return ueMapper.toDto(saved);
    }

    @Override
    public Set<UEDto> list() {
        Set<UE> entities = new LinkedHashSet<>();
        ueRepository.findAll().iterator().forEachRemaining(entities::add);
        return ueMapper.toDto(entities);
    }

    @Override
    public UEDto update(Long id, UEDto dto) {
        return ueRepository.findById(id)
                .map(ue -> {
                    ue.setCode(dto.getCode());
                    ue.setNom(dto.getNom());
                    UE saved = ueRepository.save(ue);
                    log.info("Mise à jour UE {} OK", saved.getId());
                    return ueMapper.toDto(saved);
                })
                .orElseThrow(() -> new RuntimeException("UE inconnue"));
    }

    @Override
    public boolean delete(Long id) {
        ueRepository.deleteById(id);
        return true;
    }
}
