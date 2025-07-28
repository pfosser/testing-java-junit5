package guru.springframework.sfgpetclinic.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import guru.springframework.sfgpetclinic.ModelTest;

class OwnerTest implements ModelTest {

	@Test
	void dependentAssertions() {
		Owner owner = new Owner(1L, "Joe", "Buck");
		owner.setCity("Key West");
		owner.setTelephone("123456789");

		assertAll("Properties test", () -> {
			assertAll("Person properties", //
					() -> assertEquals("Joe", owner.getFirstName(), "First name did not match"), //
					() -> assertEquals("Buck", owner.getLastName()) //
			);
		}, () -> {
			assertAll("Owner properties", //
					() -> assertEquals("Key West", owner.getCity(), "City did not match"), //
					() -> assertEquals("123456789", owner.getTelephone()) //
			);
		});

		MatcherAssert.assertThat(owner.getCity(), is("Key West"));
	}

	@DisplayName("Value source test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ValueSource(strings = { "Spring", "Framework", "Guru" })
	void testValueSource(String val) {
		System.out.println(val);
	}

	@DisplayName("Enum source test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}

}
