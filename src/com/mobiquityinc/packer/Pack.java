package com.mobiquityinc.packer;

public class Pack {
	int index;
	double weight;
	double cost;
	
	public Pack(int index, double weight, double cost) {
		super();
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
