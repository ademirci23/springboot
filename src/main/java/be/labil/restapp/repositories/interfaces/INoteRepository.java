package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByEtudiantId(Long etudiantId);
}
