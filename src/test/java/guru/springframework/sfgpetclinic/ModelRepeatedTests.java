package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeated")
public interface ModelRepeatedTests {

	@BeforeEach
	default void beforeEachMethod(TestInfo testInfo,
			// This parameter isn't going to exist for non-repeated tests
			RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
	}
}
