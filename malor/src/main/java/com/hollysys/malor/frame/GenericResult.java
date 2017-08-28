package com.hollysys.malor.frame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericResult implements Serializable {

	private String flag;
	private String prompt;
	private int rows;
	private String times;
	private String errorLvl;
	private boolean asyncInvoke = false;

	private List<Map> dataList;

	private List<Object> extDataList;

	public GenericResult() {
	}

	public GenericResult(int errorCode, String errorMsg) {
		flag = String.valueOf(errorCode);
		prompt = errorMsg;
	}

	public GenericResult(String flag, String prompt) {
		this.flag = flag;
		this.prompt = prompt;
	}

	public Boolean isSuccess() {
		return Boolean.valueOf(("0".equals(flag)) || ("100".equals(flag)));
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getErrorLvl() {
		return errorLvl;
	}

	public void setErrorLvl(String errorLvl) {
		this.errorLvl = errorLvl;
	}

	public List<Map> getDataList() {
		return null == dataList ? new ArrayList() : dataList;
	}

	public Map getDataMap() {
		return getDataList().isEmpty() ? new HashMap() : (Map) getDataList().get(0);
	}

	public void setDataList(List<Map> dataList) {
		this.dataList = dataList;
	}

	public List<Object> getExtDataList() {
		return extDataList;
	}

	public void setExtDataList(List<Object> extDataList) {
		this.extDataList = extDataList;
	}

	public boolean isAsyncInvoke() {
		return asyncInvoke;
	}

	public void setAsyncInvoke(boolean asyncInvoke) {
		this.asyncInvoke = asyncInvoke;
	}
}
