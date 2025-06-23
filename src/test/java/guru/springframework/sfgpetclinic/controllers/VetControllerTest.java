package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.map.VetMapService;

class VetControllerTest {

	private VetController controller;

	@BeforeEach
	void setUp() throws Exception {
		VetMapService vetService = new VetMapService(null);
		vetService.save(new Vet(1L, "John", "Snow", Collections.emptySet()));
		vetService.save(new Vet(2L, "Peter", "Griffin", Collections.emptySet()));

		controller = new VetController(vetService);
	}

	@Test
	void testListVets() {
		
		ModelMapImpl model = new ModelMapImpl();
		String view = controller.listVets(model);
		
		assertEquals("vets/index", view);
		assertNotEquals(0, model.getMap().size());
		assertTrue(model.getMap().containsKey("vets"));
		assertTrue(model.getMap().get("vets") instanceof Set);
	}

}
