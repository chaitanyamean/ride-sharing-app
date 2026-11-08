package com.example.ride_sharing_app.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "rider")
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String phone;
    private long createdAt;
    private boolean elite; // true = elite rider, gets matched with highest-rated drivers

    public Rider() {
    }

    public Rider(String id, String name, String email, String phone, long createdAt, boolean elite) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
        this.elite = elite;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public long getCreatedAt() { return createdAt; }
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    public boolean isElite() { return elite; }
    public void setElite(boolean elite) { this.elite = elite; }
}
