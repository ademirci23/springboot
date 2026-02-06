package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.UEDto;
import be.labil.restapp.services.interfaces.IUEService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/ue")
@AllArgsConstructor
public class UEController {

    private final IUEService ueService;

    @PostMapping(value = "/create", produces = "application/json")
    public UEDto create(@RequestBody UEDto dto) {
        return ueService.create(dto);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public Set<UEDto> list() {
        return ueService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    public UEDto update(@PathVariable Long id, @RequestBody UEDto dto) {
        return ueService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return ueService.delete(id);
    }
}
