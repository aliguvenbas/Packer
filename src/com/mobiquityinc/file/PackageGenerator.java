package com.mobiquityinc.file;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquityinc.exc.APIException;
import com.mobiquityinc.packer.Package;
import com.mobiquityinc.packer.Constants;
import com.mobiquityinc.packer.Item;

public class PackageGenerator {

	public List<Package> getPackageList(List<String> lineList) {
		return lineList.stream().map(this::getCaseByLine).collect(Collectors.toList());
	}

	public Package getCaseByLine(String line) {
		
		String[] splittedLine = line.split(":");//split to two, first element is weight limit
		double weightLimit = Integer.parseInt(splittedLine[0].trim());
		if(weightLimit>Constants.MAX_PACKAGE_WEIGHT) {
			throw new APIException("Maximum wight limit of an package can be 100");
		}
		List<String> splittedItemList = Arrays.asList(splittedLine[1].trim().split("\\)"));
		List<Item> itemList = splittedItemList.stream()//get itemList from various modification
				.map(sp -> sp.replace("(", ""))
				.map(this::stringToPack)
				.collect(Collectors.toList());
		Package case_ = new Package(weightLimit, itemList);
		return case_;
	}

	public Item stringToPack(String strPack) {
		Item pack = null;
		String[] packVariables = strPack.split(",");
		try {
			if(Double.parseDouble(packVariables[1])> Constants.MAX_ITEM_WEIGHT) {
				throw new APIException("Maximum weight limit of an item can be 100");
			}
			
			if( Double.parseDouble(packVariables[2].replaceAll("€", ""))> Constants.MAX_ITEM_COST) {
				throw new APIException("Maximum cost limit of an item can be 100");
			}
			pack = new Item(Integer.parseInt(packVariables[0].trim()), Double.parseDouble(packVariables[1]), Double.parseDouble(packVariables[2].replaceAll("€", "")));
		} catch (NumberFormatException e) {
		}
		return pack;
	}

}
