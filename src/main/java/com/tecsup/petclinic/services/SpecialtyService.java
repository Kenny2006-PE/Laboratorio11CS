package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;

import java.util.List;

/**
 *
 * @author jgomezm
 *
 */
public interface SpecialtyService {

    Speciality create(Speciality speciality);

    Speciality update(Speciality speciality);

    void delete(Integer id) throws SpecialityNotFoundException;

    Speciality findById(Integer id) throws SpecialityNotFoundException;

    List<Speciality> findAll();
}
