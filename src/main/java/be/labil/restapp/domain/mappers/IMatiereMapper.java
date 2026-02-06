package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.domain.entities.Matiere;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IMatiereMapper extends IGenericMapper<MatiereDto, Matiere> {

    @Override
    @Mapping(source = "ue.id", target = "ueId")
    MatiereDto toDto(Matiere entity);

    @Override
    @Mapping(target = "ue", ignore = true) // le service rattache l'UE via repository
    Matiere toEntity(MatiereDto dto);
}