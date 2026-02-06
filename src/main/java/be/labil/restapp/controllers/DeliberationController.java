package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.DeliberationResultDto;
import be.labil.restapp.services.interfaces.IDeliberationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deliberation")
@AllArgsConstructor
public class DeliberationController {

    private final IDeliberationService deliberationService;

    @GetMapping(value = "/{etudiantId}", produces = "application/json")
    public DeliberationResultDto deliberate(@PathVariable Long etudiantId) {
        return deliberationService.deliberate(etudiantId);
    }
}
