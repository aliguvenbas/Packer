package com.mobiquityinc.calculater;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mobiquityinc.packer.Case;
import com.mobiquityinc.packer.Pack;

public class CaseCalculater {

	List<Node> nodeList = new ArrayList<Node>();
	StringBuffer results = new StringBuffer();

	public void getResults(List<Case> caseList) {
		for (Case cs : caseList) {
			double weightLimit = cs.getWeightLimit();
			List<Pack> packList = cs.getPackList();
			if (packList.size() == 1) {
				cs.setResult("-");
			} else {
				nodeList.clear();
				generateNodes(weightLimit, packList, 0, null);
				Optional<Node> mostValuableNode = nodeList.stream()
						.sorted((n1, n2)->{
							if(n1.getTotalCost()> n2.getTotalCost()) {
								return -1;
							}else if(n1.getTotalCost()< n2.getTotalCost()) {
								return 1;
							}else {
								if(n1.getTotalWeight()< n2.getTotalWeight()) {
									return -1;
								}else if(n1.getTotalWeight()> n2.getTotalWeight()) {
									return 1;
								}else {
									return 0;
								}	
							}
						})
						.findFirst();
				cs.setResult(mostValuableNode.get().getId());
			}
		}
	}

	private void generateNodes(double weightLimit, List<Pack> packList, int startIndex, Node prevNode) {

		Node node = null;
		double prevTotalWeight = 0;
		double prevTotalCost = 0;
		String prevId = "";

		for (int i = startIndex; i < packList.size(); i++) {
			if (prevNode != null) {
				prevTotalWeight = prevNode.getTotalWeight();
				prevTotalCost = prevNode.getTotalCost();
				prevId = prevNode.getId();
			}
			double newTotalWeight = prevTotalWeight + packList.get(i).getWeight();
			if (newTotalWeight < weightLimit) {
				double newTotalCost = prevTotalCost + packList.get(i).getCost();
				String newId = (prevId.isEmpty() ? "" : (prevId + ",")) + packList.get(i).getIndex();
				node = new Node(prevNode, newTotalWeight, newTotalCost, newId);
				// System.out.println(newId + " - " + newTotalCost + "--" + " -
				// " + (node.getPrevNode() == null ? "null" :
				// node.getPrevNode().getTotalWeight()));
				int nextStartIndex = i + 1;
				nodeList.add(node);
				generateNodes(weightLimit, packList, i + 1, node);
			}
		}
	}
}