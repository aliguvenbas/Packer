package com.mobiquityinc.packer;

import java.util.List;

import com.mobiquityinc.calculater.CaseCalculater;
import com.mobiquityinc.exc.APIException;
import com.mobiquityinc.file.CaseGenerator;
import com.mobiquityinc.file.FileRead;
import com.mobiquityinc.printer.ResultBoard;

public class Packer {
	public static String pack(String filePath) throws APIException {

		FileRead fileRead = new FileRead();
		List<String> readedLines = fileRead.readFile(filePath);

		CaseGenerator caseGenerator = new CaseGenerator();
		List<Case> caseList = caseGenerator.getCaseList(readedLines);

		CaseCalculater calculater = new CaseCalculater();
		calculater.getResults(caseList);
		
		ResultBoard board = new ResultBoard();
		return board.showResults(caseList);
	}
}
