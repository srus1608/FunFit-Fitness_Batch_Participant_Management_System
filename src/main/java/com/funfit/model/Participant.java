package com.funfit.model;

public class Participant {
    private int id;
    private String name;
    private Integer age;
    private String phone;
    private String email;
    private Integer batchId;

    public Participant() {}
    public Participant(int id, String name, Integer age, String phone, String email, Integer batchId) {
        this.id = id; this.name = name; this.age = age; this.phone = phone; this.email = email; this.batchId = batchId;
    }
    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Integer getBatchId() { return batchId; }
    public void setBatchId(Integer batchId) { this.batchId = batchId; }
}
