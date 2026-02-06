package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatiereRepository extends JpaRepository<Matiere, Long> {
}
