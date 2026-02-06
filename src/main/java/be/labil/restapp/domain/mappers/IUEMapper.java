package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.UEDto;
import be.labil.restapp.domain.entities.UE;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUEMapper extends IGenericMapper<UEDto, UE> {
}
