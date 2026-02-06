package be.labil.restapp.repositories.interfaces;
import be.labil.restapp.domain.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEtudiantRepository extends JpaRepository<Etudiant, Long> {
}
