package be.labil.restapp.repositories.interfaces;

import be.labil.restapp.domain.entities.UE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUERepository extends JpaRepository<UE, Long> {
}

