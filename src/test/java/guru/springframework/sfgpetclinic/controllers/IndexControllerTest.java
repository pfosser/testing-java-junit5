package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@Tag("controller")
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
		
		assertThat(indexController.index()).isEqualTo("index");
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

	@Test
	void testAssumptionTrue() {
		// Useful to enable a test for a certain enviroment.
		// The test doesn't fail if the assumption is not met.
		assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}

	@Test
	void testAssumptionTrueAssumptioIsTrue() {
		assumeTrue("GURU".equalsIgnoreCase("GURU"));
	}
	
	@EnabledOnOs(OS.MAC)
	@Test
	void testMeOnMacOS() {
		
	}
	
	@EnabledOnOs(OS.WINDOWS)
	@Test
	void testMeOnWindows() {
		
	}
	
	@EnabledOnOs(OS.LINUX)
	@Test
	void testMeOnLinux() {
		
	}
	
	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void testMeOnJava8() {
		
	}
	
	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testMeOnJava11() {
		
	}
	
	@EnabledIfEnvironmentVariable(named = "USER", matches = "paofos")
	@Test
	void testIfUserPaofos() {
		
	}
	
	@EnabledIfEnvironmentVariable(named = "USER", matches = "fred")
	@Test
	void testIfUserFred() {
		
	}

}
