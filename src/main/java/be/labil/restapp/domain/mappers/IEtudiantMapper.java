package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.dtos.EtudiantDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IEtudiantMapper extends IGenericMapper<EtudiantDto, Etudiant> {

}