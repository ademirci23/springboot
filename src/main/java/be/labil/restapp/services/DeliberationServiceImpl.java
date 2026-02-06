package be.labil.restapp.services;

import be.labil.restapp.domain.dtos.DeliberationResultDto;
import be.labil.restapp.domain.entities.Note;
import be.labil.restapp.repositories.interfaces.INoteRepository;
import be.labil.restapp.services.interfaces.IDeliberationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliberationServiceImpl implements IDeliberationService {

    private final INoteRepository noteRepository;

    @Override
    public DeliberationResultDto deliberate(Long etudiantId) {

        List<Note> notes = noteRepository.findByEtudiantId(etudiantId);

        if (notes.isEmpty()) {
            throw new RuntimeException("Aucune note pour cet étudiant");
        }

        double sommePonderee = 0.0;
        int sommeCredits = 0;

        for (Note n : notes) {
            if (n.getMatiere() == null) {
                continue;
            }
            Integer credits = n.getMatiere().getCredits();
            Integer valeur = n.getValeur();

            if (credits == null || valeur == null) {
                continue;
            }

            sommePonderee += valeur * credits;
            sommeCredits += credits;
        }

        if (sommeCredits == 0) {
            throw new RuntimeException("Impossible de calculer la moyenne (crédits manquants)");
        }

        double moyenne = sommePonderee / sommeCredits;
        String decision = (moyenne >= 10.0) ? "REUSSITE" : "ECHEC";

        return new DeliberationResultDto(etudiantId, moyenne, decision);
    }
}
