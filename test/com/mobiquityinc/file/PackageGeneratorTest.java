package com.mobiquityinc.file;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.exc.APIException;
import com.mobiquityinc.packer.Package;
import com.mobiquityinc.packer.Item;

class PackageGeneratorTest {

	PackageGenerator caseGenerator;

	@BeforeEach
	void init() {
		caseGenerator = new PackageGenerator();
	}
	

	@Test
	@DisplayName("cost limit of an item is 100, if more than 100 throw exception")
	void test8() {
		String line = "81 : (1,91,€134)";
		assertThrows(APIException.class, ()->caseGenerator.getPackageList(Arrays.asList(line)));

	}
	
	
	@Test
	@DisplayName("weight limit of an item is 100, if more than 100 throw exception")
	void test7() {
		String line = "81 : (1,101,€34)";
		assertThrows(APIException.class, ()->caseGenerator.getPackageList(Arrays.asList(line)));

	}
	
	@Test
	@DisplayName("line to case test, more than one pack")
	void test6() {
		String line = "8 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) ";
		Package caseexpected = new Package(8, Arrays.asList(new Item(1, 15.3, 34),
				new Item(2,88.62,98),
				new Item(3,78.48,3)));
		Package actual = caseGenerator.getCaseByLine(line);
		assertAll(
				() -> assertEquals(caseexpected.getWeightLimit(), actual.getWeightLimit()), 
				() -> assertEquals(caseexpected.getPackList().size(), actual.getPackList().size()),
				() -> assertEquals(caseexpected.getPackList().get(0).getIndex(), actual.getPackList().get(0).getIndex()),
			    () -> assertEquals(caseexpected.getPackList().get(1).getWeight(),actual.getPackList().get(1).getWeight())
			    );

	}
	
	@Test
	@DisplayName("One case test")
	void test() {
		String line = "8 : (1,15.3,€34)";
		Package case_ = new Package(8, Arrays.asList(new Item(1, 15.3, 34)));
		assertAll(() -> assertEquals(case_.getWeightLimit(), caseGenerator.getPackageList(Arrays.asList(line)).get(0).getWeightLimit()), 
				() -> assertEquals(case_.getPackList().size(), caseGenerator.getPackageList(Arrays.asList(line)).get(0).getPackList().size()));

	}

	@Test
	@DisplayName("line to case test, one pack")
	void test1() {
		String line = "8 : (1,15.3,€34)";
		Package case_ = new Package(8, Arrays.asList(new Item(1, 15.3, 34)));
		assertAll(() -> assertEquals(case_.getWeightLimit(), caseGenerator.getCaseByLine(line).getWeightLimit()), 
				() -> assertEquals(case_.getPackList().size(), caseGenerator.getCaseByLine(line).getPackList().size()));

	}

	@Test
	@DisplayName("pack generation test, invalid input type")
	void test2() {
		String line = "(1,15.3,€34)";
		assertNull(caseGenerator.stringToPack(line));
	}

	@Test
	@DisplayName("pack generation test,valid input type")
	void test3() {
		String line = "1,15.3,€34";
		Item packExpected = new Item(1, 15.3, 34);
		Item packActual = caseGenerator.stringToPack(line);
		assertAll(() -> assertEquals(packExpected.getIndex(), packActual.getIndex()), 
				() -> assertEquals(packExpected.getWeight(), packActual.getWeight()), 
				() -> assertEquals(packExpected.getCost(), packActual.getCost()));

	}

}
