package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.CreateNoteRequest;
import be.labil.restapp.domain.dtos.NoteDto;

import java.util.Set;

public interface INoteService {
    NoteDto create(CreateNoteRequest req);
    Set<NoteDto> list();
    NoteDto update(Long id, CreateNoteRequest req);
    boolean delete(Long id);
}
