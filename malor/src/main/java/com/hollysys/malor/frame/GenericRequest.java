package com.hollysys.malor.frame;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GenericRequest implements Serializable {
	private static final long serialVersionUID = 3260566951421242864L;
	protected Map<String, Object> requestParams;
	protected HttpServletRequest request;
	protected Map<String, String> commParams;

	public GenericRequest() {
	}

	public GenericRequest(Map<String, Object> requestParams, Map<String, String> commParams) {
		this.requestParams = requestParams;
		this.commParams = commParams;
	}

	public Map<String, Object> getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(Map<String, Object> requestParams) {
		this.requestParams = requestParams;
	}

	public Map<String, String> getCommParams() {
		return commParams;
	}

	public void setCommParams(Map<String, String> commParams) {
		this.commParams = commParams;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpSession getSession() {
		HttpServletRequest request = getRequest();
		return null == request ? null : request.getSession();
	}

	public Map<String, String> getOpInfo() {
		HttpSession session = getSession();
		return null == session ? null : (Map<String,String>) session.getAttribute("USER_INFO");
	}
}
