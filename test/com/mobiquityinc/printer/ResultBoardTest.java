package com.mobiquityinc.printer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.packer.Package;

class ResultBoardTest {

	ResultBoard resultBoard;

	@BeforeEach
	void init() {
		resultBoard = new ResultBoard();
	}

	@Test
	@DisplayName("empty case list")
	void test2() {
		assertEquals("no valid result", resultBoard.showResults(new ArrayList<>()));
	}

	@Test
	@DisplayName("null case list")
	void test1() {
		assertEquals("no valid result", resultBoard.showResults(null));
	}

	@Test
	@DisplayName("valid, 4 different case result")
	void test() {
		List<Package> caseList = Arrays.asList(new Package(0.0, null, "1,4"), new Package(0.0, null, "-"), new Package(0.0, null, "2,3"), new Package(0.0, null, "6"));
		String expected = "1,4\n-\n2,3\n6\n";
		assertEquals(expected, resultBoard.showResults(caseList));
	}

}
