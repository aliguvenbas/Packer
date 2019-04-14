package com.mobiquityinc.printer;

import java.util.List;

import com.mobiquityinc.packer.Package;

public class ResultBoard {

	public String showResults(List<Package> packageList) {
		StringBuffer result = new StringBuffer();
		if (packageList != null && packageList.size() > 0) {
			packageList.stream().forEach(package_ -> result.append(package_.getResult() + "\n"));
		} else {
			result.append("no valid result");
		}
		System.out.println(result.toString());
		return result.toString();
	}

}
