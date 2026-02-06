package be.labil.restapp.services.interfaces;

import be.labil.restapp.domain.dtos.DeliberationResultDto;

public interface IDeliberationService {
    DeliberationResultDto deliberate(Long etudiantId);
}
