package com.hollysys.malor.frame;

public class ErrorStack {
    private int errorCode=0;
    private String errorMsg="";
    private String errorLvl="";
    private String[] params = new String[0];
    
    public ErrorStack(){
    	
    }
    
    public ErrorStack(int errorCode,String errorMsg,String erroeLvl,String[] params){
    	this.errorCode = errorCode;
    	this.errorMsg=errorMsg;
    	this.errorLvl=errorLvl;
    	this.params=params;
    }

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorLvl() {
		return errorLvl;
	}

	public void setErrorLvl(String errorLvl) {
		this.errorLvl = errorLvl;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}
