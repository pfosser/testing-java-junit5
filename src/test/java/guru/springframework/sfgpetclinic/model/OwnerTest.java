package guru.springframework.sfgpetclinic.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("model")
class OwnerTest {

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

}
