package com.hollysys.malor.frame;

public class DynamicDictRequest extends GenericRequest {
	private static final long serialVersionUID = 5706209629260967688L;

	private String dictVal;
	private String dictDes;

	public String getDictVal() {
		return dictVal;
	}

	public void setDictVal(String dictVal) {
		this.dictVal = dictVal;
	}

	public String getDictDes() {
		return dictDes;
	}

	public void setDictDes(String dictDes) {
		this.dictDes = dictDes;
	}
}
