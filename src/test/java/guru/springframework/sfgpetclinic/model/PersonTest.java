package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("model")
class PersonTest {

	@Test
	void groupedAssertions() {
		// given
		Person person = new Person(1L, "Joe", "Buck");

		// then
		assertAll("Test props set", //
				() -> assertEquals("Joe", person.getFirstName()), //
				() -> assertEquals("Buck", person.getLastName()));
	}

	@Test
	void groupedAssertionsMessage() {
		// given
		Person person = new Person(1L, "Joe", "Buck");

		// then
		assertAll("Test props set", //
				() -> assertEquals("Joe", person.getFirstName(), "First name failed"), //
				() -> assertEquals("Buck", person.getLastName(), "Last name failed"));
	}

}
