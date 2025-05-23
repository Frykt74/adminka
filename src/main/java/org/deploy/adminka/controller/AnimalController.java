package org.deploy.adminka.controller;

import org.deploy.adminka.models.Animal;
import org.deploy.adminka.repository.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    private final AnimalRepository repo;

    public AnimalController(AnimalRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Animal>> all() {
        return ResponseEntity.ok(repo.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> one(@PathVariable int id) {
        Animal a = repo.get(id);
        return a != null
                ? ResponseEntity.ok(a)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public ResponseEntity<Animal> create(@RequestBody Animal a) {
        repo.add(a);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable int id, @RequestBody Animal a) {
        if (repo.get(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        a.setId(id);
        repo.update(id, a);
        return ResponseEntity.ok(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        repo.delete(id);
        return ResponseEntity.noContent().build();
    }
}
