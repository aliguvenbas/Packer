package com.mobiquityinc.calculater;

public class Node {
	Node prevNode;
	double totalWeight;
	double totalCost;
	String id = "";

	public Node(Node prevNode, double totalWeight, double totalCost, String id) {
		this.prevNode = prevNode;
		this.totalWeight = totalWeight;
		this.totalCost = totalCost;
		this.id = id;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

	public double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
