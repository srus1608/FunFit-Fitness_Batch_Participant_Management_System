package com.funfit.model;

public class Batch {
    private int id;
    private String name;
    private String timing;
    private int capacity;

    public Batch() {}
    public Batch(int id, String name, String timing, int capacity) {
        this.id = id; this.name = name; this.timing = timing; this.capacity = capacity;
    }
    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTiming() { return timing; }
    public void setTiming(String timing) { this.timing = timing; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
