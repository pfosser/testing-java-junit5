package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelTest;

class PersonTest implements ModelTest {

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

	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
	@DisplayName("My repeated test")
	void myRepeatedTest() {

	}
	
	@RepeatedTest(5)
	void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
	}
}
