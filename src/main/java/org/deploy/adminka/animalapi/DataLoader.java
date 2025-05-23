package org.deploy.adminka.animalapi;

import org.deploy.adminka.models.Animal;
import org.deploy.adminka.models.Habitat;
import org.deploy.adminka.repository.AnimalRepository;
import org.deploy.adminka.repository.HabitatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final AnimalRepository animalRepo;
    private final HabitatRepository habitatRepo;

    public DataLoader(AnimalRepository animalRepo, HabitatRepository habitatRepo) {
        this.animalRepo = animalRepo;
        this.habitatRepo = habitatRepo;
    }

    @Override
    public void run(String... args) {
        animalRepo.add(new Animal(1, "Leo", "Lion"));
        animalRepo.add(new Animal(2, "Molly", "Cat"));

        habitatRepo.add(new Habitat(1, "Savannah"));
        habitatRepo.add(new Habitat(2, "House"));

        System.out.println("Loaded sample animals and habitats");
    }
}
