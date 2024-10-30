package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author jgomezm
 *
 */
@Entity(name = "specialities")
@Data
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Speciality() {}

    public Speciality(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters (lombok @Data generates these)
}
