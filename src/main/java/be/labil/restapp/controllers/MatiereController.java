package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.CreateMatiereRequest;
import be.labil.restapp.domain.dtos.MatiereDto;
import be.labil.restapp.services.interfaces.IMatiereService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/matiere")
@AllArgsConstructor
public class MatiereController {

    private final IMatiereService matiereService;

    @PostMapping(value = "/create", produces = "application/json")
    public MatiereDto create(@RequestBody CreateMatiereRequest req) {
        return matiereService.create(req);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public Set<MatiereDto> list() {
        return matiereService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    public MatiereDto update(@PathVariable Long id, @RequestBody CreateMatiereRequest req) {
        return matiereService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return matiereService.delete(id);
    }
}
