package robledo.home.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    private long id;

    private String name;

    @OneToMany
    private List<Transaction> transactions;

    // getters and setters
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
