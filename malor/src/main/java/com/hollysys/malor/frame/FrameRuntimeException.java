package com.hollysys.malor.frame;


public class FrameRuntimeException extends RuntimeException{
	private static final long serialVersionUID = -5403548049750455438L;
	private int errorCode;
	private String errorLvl;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorLvl() {
		return errorLvl;
	}
	public void setErrorLvl(String errorLvl) {
		this.errorLvl = errorLvl;
	}
	
	public FrameRuntimeException(){
		super("框架运行时异常");
		this.errorCode=-9999;
	}
	public FrameRuntimeException(String paramString) {
		super(paramString);
	}
	
	public FrameRuntimeException(String paramString,Throwable cause){
		super(paramString,cause);
		this.errorCode=-9999;
	}
	
	public FrameRuntimeException(Throwable cause){
	    super(cause); 
	}
	
	public FrameRuntimeException(String errorCode,String paramString,Throwable cause){
		this(paramString,cause);	
		this.errorCode=-9999;
	}	
	
	public String toString() {
		String s =errorCode + "--"+ super.getClass().getName();
		String message = getLocalizedMessage();
		return ((message != null) ? s + ": " + message : s);
	}
} 
