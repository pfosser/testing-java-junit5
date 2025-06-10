package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

	IndexController indexController;

	@BeforeEach
	void setUp() throws Exception {
		indexController = new IndexController();
	}

	@Test
	void testIndex() {
		assertEquals("index", indexController.index());
		assertEquals("index", indexController.index(), "Wrong view returned");

		assertEquals("index", indexController.index(), () -> "Another expensive message." //
				+ " Make me only if you have to");
	}

	@Test
	void testOupsHandler() {
		assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "This is some expensive" //
				+ " message to build" //
				+ " for my test");
	}

}
