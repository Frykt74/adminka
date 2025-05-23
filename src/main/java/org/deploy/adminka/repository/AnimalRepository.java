package org.deploy.adminka.repository;

import org.deploy.adminka.models.Animal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AnimalRepository {
    private final Map<Integer, Animal> map = new HashMap<>();

    public Map<Integer, Animal> getAll() {
        return map;
    }

    public Animal get(int id) {
        return map.get(id);
    }

    public void add(Animal a) {
        map.put(a.getId(), a);
    }

    public void update(int id, Animal a) {
        map.put(id, a);
    }

    public void delete(int id) {
        map.remove(id);
    }
}
