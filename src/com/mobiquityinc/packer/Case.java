package com.mobiquityinc.packer;

import java.util.List;

public class Case {
	double weightLimit;
	List<Pack> packList;
	String result;

	public Case(double weightLimit, List<Pack> packList) {
		super();
		this.weightLimit = weightLimit;
		this.packList = packList;
	}
	
	

	public Case(double weightLimit, List<Pack> packList, String result) {
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

	public List<Pack> getPackList() {
		return packList;
	}

	public void setPackList(List<Pack> packList) {
		this.packList = packList;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
