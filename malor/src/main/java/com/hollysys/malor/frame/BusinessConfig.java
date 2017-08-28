package com.hollysys.malor.frame;

public class BusinessConfig {
	private long id;
	private String serviceCode;
	private String businessCode;
	private String businessMethod;
	private int serialNo;
	private String businessName;
	private String businessDesc;
	private int businessType;
	private int businessCate;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;
	private int modifyOper;
	private String modifyTime;

	public void postSetMethod() {
		businessName = ((businessName == null)
				|| (businessName.trim().length() == 0) ? businessCode
				: businessName);
		businessDesc = ((businessDesc == null)
				|| (businessDesc.trim().length() == 0) ? businessName
				: businessDesc);
		businessCate = (businessCate == 0 ? 1 : businessCate);
		businessType = (businessType == 0 ? 1 : businessType);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getBusinessMethod() {
		return businessMethod;
	}

	public void setBusinessMethod(String businessMethod) {
		this.businessMethod = businessMethod;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessDesc() {
		return businessDesc;
	}

	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public int getBusinessCate() {
		return businessCate;
	}

	public void setBusinessCate(int businessCate) {
		this.businessCate = businessCate;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	public int getModifyOper() {
		return modifyOper;
	}

	public void setModifyOper(int modifyOper) {
		this.modifyOper = modifyOper;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

}
