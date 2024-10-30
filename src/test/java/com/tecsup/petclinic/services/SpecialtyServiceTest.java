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
}
