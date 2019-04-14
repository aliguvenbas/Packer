package com.mobiquityinc.calculater;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mobiquityinc.packer.Case;
import com.mobiquityinc.packer.Pack;

class CaseCalculaterTest {
	CaseCalculater caseCalculater;

	@BeforeEach
	void init() {
		caseCalculater = new CaseCalculater();
	}

	@Test
	@DisplayName("test 2, 3 different cases")
	void test2() {
		Case case1  = new Case(81, Arrays.asList(
				new Pack(1, 15, 34),
				new Pack(2,88,3),
				new Pack(3,48,98),
				new Pack(4,10,4),
				new Pack(5,30,7)));
		Case case2  = new Case(8, Arrays.asList(
				new Pack(1, 15.3, 34)));
		
		Case case3  = new Case(75, Arrays.asList(
				new Pack(1, 85.31, 29),
				new Pack(2,14.55,74),
				new Pack(3,3.98,16),
				new Pack(4,26.24,55),
				new Pack(5,63.69,52),
				new Pack(6,76.25,75),
				new Pack(7,60.02,74),
				new Pack(8,93.18,35),
				new Pack(9,89.95,78)));
		List<Case> caseList = Arrays.asList(case1,case2,case3);
		caseCalculater.getResults(caseList);
		assertAll(()->assertEquals("1,3,4",case1.getResult()),
				()->assertEquals("-",case2.getResult()),
				()->assertEquals("2,7",case3.getResult()));
		
	}
	
	@Test
	@DisplayName("test 1, only one case")
	void test() {
		Case case1  = new Case(81, Arrays.asList(
				new Pack(1, 15, 34),
				new Pack(2,88,3),
				new Pack(3,48,98),
				new Pack(4,10,4),
				new Pack(5,30,7)));
		List<Case> caseList = Arrays.asList(case1);
		caseCalculater.getResults(caseList);
		assertEquals("1,3,4",case1.getResult());
		
	}

}
