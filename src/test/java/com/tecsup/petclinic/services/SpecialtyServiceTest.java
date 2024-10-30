package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.tecsup.petclinic.entities.Speciality;
import com.tecsup.petclinic.exception.SpecialityNotFoundException;
import com.tecsup.petclinic.repositories.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpecialtyServiceTest {

	@Mock
	private SpecialtyRepository specialtyRepository;

	@InjectMocks
	private SpecialtyServiceImpl specialtyService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateSpeciality() {
		Speciality speciality = new Speciality(null, "Cardiology");
		when(specialtyRepository.save(any(Speciality.class))).thenReturn(speciality);

		Speciality createdSpeciality = specialtyService.create(speciality);
		assertNotNull(createdSpeciality);
		assertEquals("Cardiology", createdSpeciality.getName());
	}

	@Test
	public void testUpdateSpeciality() {
		Speciality speciality = new Speciality(1, "Cardiology");
		when(specialtyRepository.save(speciality)).thenReturn(speciality);

		Speciality updatedSpeciality = specialtyService.update(speciality);
		assertNotNull(updatedSpeciality);
		assertEquals("Cardiology", updatedSpeciality.getName());
	}
	@Test
	public void testDeleteSpeciality() throws SpecialityNotFoundException {
		Speciality speciality = new Speciality(1, "Cardiology");
		when(specialtyRepository.findById(1)).thenReturn(Optional.of(speciality));

		specialtyService.delete(1);
		verify(specialtyRepository, times(1)).delete(speciality);
	}

	@Test
	public void testFindAllSpecialities() {
		List<Speciality> specialities = new ArrayList<>();
		specialities.add(new Speciality(1, "Cardiology"));
		specialities.add(new Speciality(2, "Dermatology"));

		when(specialtyRepository.findAll()).thenReturn(specialities);

		List<Speciality> foundSpecialities = specialtyService.findAll();
		assertEquals(2, foundSpecialities.size());
	}
}
