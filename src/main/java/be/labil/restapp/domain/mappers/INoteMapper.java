package be.labil.restapp.domain.mappers;

import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Note;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface INoteMapper extends IGenericMapper<NoteDto, Note> {

    @Override
    @Mapping(source = "etudiant.id", target = "etudiantId")
    @Mapping(source = "matiere.id", target = "matiereId")
    NoteDto toDto(Note entity);

    @Override
    @Mapping(target = "etudiant", ignore = true) // service rattache l'étudiant via repository
    @Mapping(target = "matiere", ignore = true)  // service rattache la matière via repository
    Note toEntity(NoteDto dto);
}
