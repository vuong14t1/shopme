package com.shopme.shopmecommon.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false, unique = true)
    private String name;

    @Column(length = 150, nullable = false)
    private String description;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Role(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
