package com.mobiquityinc.packer;

import java.util.List;

public class Package {
	double weightLimit;
	List<Item> packList;
	String result;

	public Package(double weightLimit, List<Item> packList) {
		super();
		this.weightLimit = weightLimit;
		this.packList = packList;
	}
	
	

	public Package(double weightLimit, List<Item> packList, String result) {
		super();
		this.weightLimit = weightLimit;
		this.packList = packList;
		this.result = result;
	}

	public double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public List<Item> getPackList() {
		return packList;
	}

	public void setPackList(List<Item> packList) {
		this.packList = packList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
