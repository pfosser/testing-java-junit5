package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;

public class PersonRepeatedTests implements ModelRepeatedTests {

	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
	@DisplayName("My repeated test")
	void myRepeatedTest() {

	}
	
	@RepeatedTest(5)
	void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() + ": " + repetitionInfo.getCurrentRepetition());
	}

	@RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} | {totalRepetitions}")
	@DisplayName("Assignment repeated test")
	void assignmentTest() {
		
	}

}
