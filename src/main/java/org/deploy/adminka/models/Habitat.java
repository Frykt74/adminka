package org.deploy.adminka.models;

public class Habitat {
    private int id;
    private String description;

    public Habitat() {}

    public Habitat(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}