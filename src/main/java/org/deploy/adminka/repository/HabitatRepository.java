package org.deploy.adminka.repository;

import org.deploy.adminka.models.Habitat;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HabitatRepository {
    private final Map<Integer, Habitat> map = new HashMap<>();

    public Map<Integer, Habitat> getAll() {
        return map;
    }

    public Habitat get(int id) {
        return map.get(id);
    }

    public void add(Habitat h) {
        map.put(h.getId(), h);
    }

    public void update(int id, Habitat h) {
        map.put(id, h);
    }

    public void delete(int id) {
        map.remove(id);
    }
}
