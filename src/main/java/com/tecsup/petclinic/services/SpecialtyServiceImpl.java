package com.tecsup.petclinic.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jgomezm
 *
 */
@Service
@Slf4j
public class SpecialtyServiceImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Speciality create(Speciality speciality) {
        return specialtyRepository.save(speciality);
    }

    @Override
    public Speciality update(Speciality speciality) {
        return specialtyRepository.save(speciality);
    }

    @Override
    public void delete(Integer id) throws SpecialityNotFoundException {
        Speciality speciality = findById(id);
        specialtyRepository.delete(speciality);
    }

    @Override
    public Speciality findById(Integer id) throws SpecialityNotFoundException {
        Optional<Speciality> speciality = specialtyRepository.findById(id);
        if (!speciality.isPresent()) {
            throw new SpecialityNotFoundException("Speciality not found with id: " + id);
        }
        return speciality.get();
    }

    @Override
    public List<Speciality> findAll() {
        return specialtyRepository.findAll();
    }
}