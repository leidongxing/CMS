package com.hollysys.malor.frame;

import java.util.Map;

public class BusinessFactory {
	private Map<String, IBusiness> businessMap;

	public Map<String, IBusiness> getBusinessMap() {
		return businessMap;
	}

	public void setBusinessMap(Map<String, IBusiness> businessMap) {
		this.businessMap = businessMap;
	}

	public IBusiness getBusinessInstance(int businessType) throws Exception {
		switch (businessType) {
		case 1:
			return (IBusiness) businessMap.get("bex");
		case 2:
			return (IBusiness) businessMap.get("bo");
		case 3:
			return (IBusiness) businessMap.get("atom");
		}
		LogUtil.error("非法的businessType [" + businessType + "]");

		throw new Exception("非法的businessType [" + businessType + "]");
	}
}
