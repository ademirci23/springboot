package be.labil.restapp.controllers;

import be.labil.restapp.domain.dtos.CreateNoteRequest;
import be.labil.restapp.domain.dtos.NoteDto;
import be.labil.restapp.services.interfaces.INoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/note")
@AllArgsConstructor
public class NoteController {

    private final INoteService noteService;

    @PostMapping(value = "/create", produces = "application/json")
    public NoteDto create(@RequestBody CreateNoteRequest req) {
        return noteService.create(req);
    }

    @GetMapping(value = "/list", produces = "application/json")
    public Set<NoteDto> list() {
        return noteService.list();
    }

    @PutMapping(value = "/update/{id}", produces = "application/json")
    public NoteDto update(@PathVariable Long id, @RequestBody CreateNoteRequest req) {
        return noteService.update(id, req);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return noteService.delete(id);
    }
}
