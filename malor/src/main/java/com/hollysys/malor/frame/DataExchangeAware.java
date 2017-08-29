package com.hollysys.malor.frame;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class DataExchangeAware implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	private DataExchangeAssembly dataExchange;

	public DataExchangeAware() {
		this.applicationContext = null;
		this.dataExchange = null;
	}

	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.applicationContext = applicationContext;
	}

	public DataExchangeAssembly getDataExchange() {
		return this.dataExchange;
	}

	public void initSetUp() {
		this.dataExchange = ((DataExchangeAssembly) this.applicationContext.getBean("dataExchange"));
	}

	public void addExceptionStack(String lvl, ErrorStack es) {
		Map stack = (Map) this.dataExchange.getServiceData("errorStack");
		if (stack == null) {
			stack = new HashMap();
			this.dataExchange.setServiceData("errorStack", stack);
		}
		stack.put(lvl, es);
	}

	public Map<String, ErrorStack> getExceptionStack() {
		return ((Map) this.dataExchange.getServiceData("errorStack"));
	}
}