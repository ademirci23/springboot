package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.UEDto;

import java.util.Set;

public interface IUEService {
    UEDto create(UEDto dto);
    Set<UEDto> list();
    UEDto update(Long id, UEDto UEdto);
    boolean delete(Long id);
}
