package com.password.validation.softserve;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SoftserveApplicationTests {
	@Test
	void testOnlyNumbers() {
		int length = 8;
		String password = "12341324";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void testOnlyCapitalLetters() {
		int length = 8;
		String password = "QAZXSWED";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void testOnlyLowerCaseLetters() {
		int length = 8;
		String password = "qazxswed";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void testMixedCapitalAndLoweCaseLetters() {
		int length = 8;
		String password = "qazxSWED";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void testCapitalAndLoweCaseLettersAndDigits() {
		int length = 8;
		String password = "qazxSWE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void testCapitalAndLoweCaseLettersAndDigitsInvalidLength() {
		int length = 7;
		String password = "qazxSWE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void testCapitalAndLoweCaseLettersAndDigitsInvalidSpecialCharacter() {
		int length = 8;
		String password = "qazx¿WE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void validPatternInvalidLength() {
		int length = 9;
		String password = "qazx?WE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void validPatternWithSpace() {
		int length = 8;
		String password = "qazx WE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void validPatternWithTab() {
		int length = 8;
		String password = "qaz	!WE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void validPatternWithReturn() {
		int length = 8;
		String password = "qa\rz!WE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertFalse(matches);
	}

	@Test
	void validPatternScenario1() {
		int length = 8;
		String password = "qazx?WE1";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertTrue(matches);
	}

	@Test
	void validPatternScenario2() {
		int length = 16;
		String password = "qazx?WE1_h67*'\\^";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertTrue(matches);
	}

	@Test
	void validPatternScenario3() {
		int length = 18;
		String password = "abc>=@WE1_h67*.'\\^";
		boolean matches = SoftserveApplication.validatePassword(length, password);

		assertTrue(matches);
	}

}
