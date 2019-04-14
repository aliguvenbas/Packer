package com.mobiquityinc.packer;

import java.util.List;

import com.mobiquityinc.calculater.PackageCalculater;
import com.mobiquityinc.exc.APIException;
import com.mobiquityinc.file.PackageGenerator;
import com.mobiquityinc.file.FileRead;
import com.mobiquityinc.printer.ResultBoard;

public class Packer {
	public static String pack(String filePath) throws APIException {
		
		//read lines from file
		FileRead fileRead = new FileRead();
		List<String> readedLines = fileRead.readFile(filePath);

		//generate package list includes items  from readed lines
		PackageGenerator packageGenerator = new PackageGenerator();
		List<Package> packageList = packageGenerator.getPackageList(readedLines);

		//calculate best packaging with
		PackageCalculater calculater = new PackageCalculater();
		calculater.getResults(packageList);
		
		//show and return best packaging items informations
		ResultBoard board = new ResultBoard();
		return board.showResults(packageList);
	}
}
