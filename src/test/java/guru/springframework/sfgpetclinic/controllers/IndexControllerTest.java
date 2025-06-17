package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

	IndexController indexController;

	@BeforeEach
	void setUp() throws Exception {
		indexController = new IndexController();
	}

	@DisplayName("Test proper view name is returned for index page")
	@Test
	void testIndex() {
		assertEquals("index", indexController.index());
		assertEquals("index", indexController.index(), "Wrong view returned");

		assertEquals("index", indexController.index(), () -> "Another expensive message." //
				+ " Make me only if you have to");
	}

	@Test
	@DisplayName("Test exception")
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class, () -> indexController.oupsHandler());
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOut() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);

			System.out.println("I got here");
		});
	}

	@Disabled("Demo of timeout")
	@Test
	void testTimeOutPreempt() {
		// This one spawns a thread.
		// You can expect to not see the console message because the
		// thread is killed if execution exceeds the duration tested
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);

			System.out.println("I got here 21264158");
		});
	}

}
