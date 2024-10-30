package com.tecsup.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecsup.petclinic.entities.Speciality;

/**
 *
 * @author jgomezm
 *
 */
@Repository
public interface SpecialtyRepository extends JpaRepository<Speciality, Integer> {
    // Puedes agregar métodos personalizados si lo necesitas
}
