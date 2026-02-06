package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.CreateNoteRequest;
import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.domain.entities.Etudiant;
import be.labil.restapp.domain.entities.Matiere;
import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.domain.mappers.INoteMapper;
import be.labil.restapp.repositories.interfaces.IEtudiantRepository;
import be.labil.restapp.repositories.interfaces.IMatiereRepository;
import be.labil.restapp.repositories.interfaces.INoteRepository;
import be.labil.restapp.services.interfaces.INoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
@Service
@AllArgsConstructor
public class NoteServiceImpl implements INoteService {

    private final INoteRepository noteRepository;
    private final IEtudiantRepository etudiantRepository;
    private final IMatiereRepository matiereRepository;
    private final INoteMapper noteMapper;

    @Override
    public NoteDto create(CreateNoteRequest req) {
        Etudiant etudiant = etudiantRepository.findById(req.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Etudiant inconnu"));
        Matiere matiere = matiereRepository.findById(req.getMatiereId())
                .orElseThrow(() -> new RuntimeException("Matiere inconnue"));

        Note note = new Note();
        note.setValeur(req.getValeur());
        note.setEtudiant(etudiant);
        note.setMatiere(matiere);

        Note saved = noteRepository.save(note);
        return noteMapper.toDto(saved);
    }

    @Override
    public Set<NoteDto> list() {
        Set<Note> entities = new LinkedHashSet<>();
        noteRepository.findAll().iterator().forEachRemaining(entities::add);
        return noteMapper.toDto(entities);
    }

    @Override
    public NoteDto update(Long id, CreateNoteRequest req) {
        Etudiant etudiant = etudiantRepository.findById(req.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Etudiant inconnu"));
        Matiere matiere = matiereRepository.findById(req.getMatiereId())
                .orElseThrow(() -> new RuntimeException("Matiere inconnue"));

        return noteRepository.findById(id)
                .map(n -> {
                    n.setValeur(req.getValeur());
                    n.setEtudiant(etudiant);
                    n.setMatiere(matiere);

                    Note saved = noteRepository.save(n);
                    log.info("Mise à jour Note {} OK", saved.getId());
                    return noteMapper.toDto(saved);
                })
                .orElseThrow(() -> new RuntimeException("Note inconnue"));
    }

    @Override
    public boolean delete(Long id) {
        noteRepository.deleteById(id);
        return true;
    }
}
