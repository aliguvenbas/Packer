package com.mobiquityinc.file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exc.APIException;

class FileReadTest {

	FileRead fileRead;

	@BeforeEach
	void init() {
		fileRead = new FileRead();
	}

	@Test
	@DisplayName("Check is file not exist")
	void test() {
		String fileName = "resources/samplexx.txt";
		assertFalse(fileRead.isFileExist(fileName));
	}
	
	@Test
	@DisplayName("Check is file exist")
	void test4() {
		String fileName = "resources/sample.txt";
		assertTrue(fileRead.isFileExist(fileName));
	}

	@Test
	@DisplayName("Check is file name null")
	void test1() {
		String fileName = null;
		assertThrows(APIException.class, () -> fileRead.readFile(fileName));
	}

	@Test
	@DisplayName("line comperator")
	void test2() {
		String fileName = "resources/sample.txt";
		String line = "You want to send your friend a package with different things.";
		assertEquals(line, fileRead.readFile(fileName).get(0));
	}
}
