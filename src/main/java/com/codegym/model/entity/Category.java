package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String typeService;

    @ManyToMany(mappedBy = "services", cascade = CascadeType.ALL)
    private Set<Rent> rents;

    public Category() {
    }

    public Category(Long id, String name, String typeService) {
        this.id = id;
        this.name = name;
        this.typeService = typeService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }
}
