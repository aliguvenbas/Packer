package com.mobiquityinc.packer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exc.APIException;

class PackerTest {

	@Test
	@DisplayName("reqular test")
	void test2() {
		String expected = "4\n-\n2,7\n8,9\n";
		assertEquals(expected, Packer.pack("resources/testCase2.txt"));
	}
	
	@Test
	@DisplayName("same price test")
	void test1() {
		String expected = "4\n-\n2,7\n8,9\n";
		assertEquals(expected, Packer.pack("resources/testCase1.txt"));
	}

	@Test
	@DisplayName("wrong file name")
	
	void test() {
		String expected = "4\n-\n2,7\n8,9\n";
		assertThrows(APIException.class, () -> Packer.pack("resıurces/testCase.txt"));
	}

}
