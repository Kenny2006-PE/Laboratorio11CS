package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author jgomezm
 *
 */
@Entity(name = "owners")
@Data
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String phone;

    public Owner() {}

    public Owner(Integer id, String name, String lastName, String address, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

}
