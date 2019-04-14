package com.mobiquityinc.file;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquityinc.packer.Case;
import com.mobiquityinc.packer.Pack;

public class CaseGenerator {

	public List<Case> getCaseList(List<String> lineList) {
		return lineList.stream().map(this::getCaseByLine).collect(Collectors.toList());
	}

	public Case getCaseByLine(String line) {
		String[] splittedLine = line.split(":");
		int index = Integer.parseInt(splittedLine[0].trim());
		List<String> splittedPackList = Arrays.asList(splittedLine[1].trim().split("\\)"));
		List<Pack> packList = splittedPackList.stream()
				.map(sp -> sp.replace("(", ""))
				.map(this::stringToPack)
				.collect(Collectors.toList());
		Case case_ = new Case(index, packList);
		return case_;
	}

	public Pack stringToPack(String strPack) {
		Pack pack = null;
		String[] packVariables = strPack.split(",");
		try {
			pack = new Pack(Integer.parseInt(packVariables[0].trim()), Double.parseDouble(packVariables[1]), Double.parseDouble(packVariables[2].replaceAll("€", "")));
		} catch (NumberFormatException e) {
		}
		return pack;
	}

}
