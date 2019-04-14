package com.mobiquityinc.calculater;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.packer.Package;
import com.mobiquityinc.packer.Item;

class packageCalculaterTest {
	PackageCalculater packCalculater;

	@BeforeEach
	void init() {
		packCalculater = new PackageCalculater();
	}

	@Test
	@DisplayName(" 3 different package, max cost constraint")
	void test3() {
		Package package1  = new Package(81, Arrays.asList(
				new Item(1, 15, 34),
				new Item(2,88,3),
				new Item(3,48,98),
				new Item(4,10,4),
				new Item(5,30,7)));
		Package package2  = new Package(8, Arrays.asList(
				new Item(1, 15.3, 34)));
		
		Package package3  = new Package(75, Arrays.asList(
				new Item(1, 85.31, 29),
				new Item(2,14.55,74),
				new Item(3,3.98,16),
				new Item(4,26.24,55),
				new Item(5,63.69,52),
				new Item(6,76.25,75),
				new Item(7,60.02,74),
				new Item(8,93.18,35),
				new Item(9,89.95,78)));
		List<Package> packageList = Arrays.asList(package1,package2,package3);
		packCalculater.getResults(packageList);
		assertAll(()->assertEquals("1,3,4",package1.getResult()),
				()->assertEquals("-",package2.getResult()),
				()->assertEquals("2,7",package3.getResult()));
		
	}
		
	
	@Test
	@DisplayName("test 2, 3 different package")
	void test2() {
		Package package1  = new Package(81, Arrays.asList(
				new Item(1, 15, 34),
				new Item(2,88,3),
				new Item(3,48,98),
				new Item(4,10,4),
				new Item(5,30,7)));
		Package package2  = new Package(8, Arrays.asList(
				new Item(1, 15.3, 34)));
		
		Package package3  = new Package(75, Arrays.asList(
				new Item(1, 85.31, 29),
				new Item(2,14.55,74),
				new Item(3,3.98,16),
				new Item(4,26.24,55),
				new Item(5,63.69,52),
				new Item(6,76.25,75),
				new Item(7,60.02,74),
				new Item(8,93.18,35),
				new Item(9,89.95,78)));
		List<Package> packageList = Arrays.asList(package1,package2,package3);
		packCalculater.getResults(packageList);
		assertAll(()->assertEquals("1,3,4",package1.getResult()),
				()->assertEquals("-",package2.getResult()),
				()->assertEquals("2,7",package3.getResult()));
		
	}
	
	@Test
	@DisplayName("test 1, only one package")
	void test() {
		Package package1  = new Package(81, Arrays.asList(
				new Item(1, 15, 34),
				new Item(2,88,3),
				new Item(3,48,98),
				new Item(4,10,4),
				new Item(5,30,7)));
		List<Package> packageList = Arrays.asList(package1);
		packCalculater.getResults(packageList);
		assertEquals("1,3,4",package1.getResult());
		
	}

}
