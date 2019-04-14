package com.mobiquityinc.printer;

import java.util.List;

import com.mobiquityinc.packer.Case;

public class ResultBoard {

	public String showResults(List<Case> caseList) {
		StringBuffer result = new StringBuffer();
		if (caseList != null && caseList.size() > 0) {
			caseList.stream().forEach(case_ -> result.append(case_.getResult() + "\n"));
		} else {
			result.append("no valid result");
		}
		System.out.println(result.toString());
		return result.toString();
	}

}
