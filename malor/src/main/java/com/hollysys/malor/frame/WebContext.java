package com.hollysys.malor.frame;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class WebContext {
	private static HttpServletRequest getRequest() {
		ServletRequestAttributes servletAttrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return servletAttrs.getRequest();
	}

	public static HttpSession getSession() {
		return getRequest().getSession();
	}

	public static Map<String, String> getOpInfo() {
		HttpSession session = getSession();
		return ((null != session)? (Map) session.getAttribute("USER_INFO"): null);
	}
}