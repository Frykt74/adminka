package org.deploy.adminka.controller;

import org.deploy.adminka.models.Habitat;
import org.deploy.adminka.repository.HabitatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/habitats")
public class HabitatController {
    private final HabitatRepository repo;

    public HabitatController(HabitatRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Habitat>> all() {
        return ResponseEntity.ok(repo.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitat> one(@PathVariable int id) {
        Habitat h = repo.get(id);
        return h != null
                ? ResponseEntity.ok(h)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Habitat> create(@RequestBody Habitat h) {
        repo.add(h);
        return ResponseEntity.status(HttpStatus.CREATED).body(h);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitat> update(@PathVariable int id, @RequestBody Habitat h) {
        if (repo.get(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        h.setId(id);
        repo.update(id, h);
        return ResponseEntity.ok(h);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
