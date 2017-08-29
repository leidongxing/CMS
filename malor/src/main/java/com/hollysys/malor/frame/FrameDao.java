package com.hollysys.malor.frame;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FrameDao implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	private static ConcurrentMap<Thread, DataExchangeAssembly> dataExchanges = new ConcurrentHashMap();

	public void initSetUp() {
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationContext = applicationContext;
	}

	public static void addDataExchanges(Thread thread,DataExchangeAssembly dataExchange) {
		dataExchanges.put(thread, dataExchange);
	}

	public static void removeDataExchanges(Thread thread) {
		dataExchanges.remove(thread);
	}

	public static GenericResult doBexInvoke(String bexCode, Map requestParams) {
		return doBexInvoke(bexCode, requestParams, null);
	}

	public static GenericResult doBexInvoke(String bexCode, Map requestParams,Map commParams) {
		BusinessInstance biz = (BusinessInstance) applicationContext.getBean("businessInstance");
		return biz.callBusiness(bexCode, requestParams, commParams, 1,dataExchanges);
	}

	public static GenericResult doAtomInvoke(String bexCode, Map requestParams) {
		return doAtomInvoke(bexCode, requestParams, WebContext.getOpInfo());
	}

	public static GenericResult doAtomInvoke(String bexCode, Map requestParams,Map commParams) {
		BusinessInstance biz = (BusinessInstance) applicationContext.getBean("businessInstance");
		return biz.callBusiness(bexCode, requestParams, commParams, 3, dataExchanges);
	}

	public static int doBexCall(String bexCode, Map requestParams,Map commParams, GenericResult result) {
		BusinessInstance biz = (BusinessInstance) applicationContext.getBean("businessInstance");
		GenericResult bussResult = biz.callBusiness(bexCode, requestParams,commParams, 1, dataExchanges);
		return resultTransform(result, bussResult);
	}

	public static int doBexCall(String bexCode, Map requestParams,GenericResult result) {
		return doBexCall(bexCode, requestParams, null, result);
	}

	public static int doAtomCall(String bexCode, Map requestParams,Map commParams, GenericResult result) {
		BusinessInstance biz = (BusinessInstance) applicationContext.getBean("businessInstance");
		GenericResult bussResult = biz.callBusiness(bexCode, requestParams,commParams, 3, dataExchanges);
		return resultTransform(result, bussResult);
	}

	public static int doAtomCall(String bexCode, Map requestParams,GenericResult result) {
		return doAtomCall(bexCode, requestParams, null, result);
	}

	public static int doAtomCall(String bexCode, Map requestParams,Map commParams, GenericResult result,DataExchangeAssembly dataExchange) {
		BusinessInstance biz = (BusinessInstance) applicationContext.getBean("businessInstance");
		GenericResult bussResult = biz.callBusiness(bexCode, requestParams,commParams, 3, dataExchanges);
		return resultTransform(result, bussResult);
	}

	private static int resultTransform(GenericResult result,GenericResult bussResult) {
		copyGenericResult(result, bussResult);
		String retCode = bussResult.getFlag();
		return Integer.parseInt(("100".equals(retCode)) ? "0" : (StringUtils.isEmpty(retCode)) ? "-1008" : retCode);
	}

	private static void copyGenericResult(GenericResult result,GenericResult newResult) {
		if (result != null) {
			result.setFlag(newResult.getFlag());
			result.setPrompt(newResult.getPrompt());
			result.setRows(newResult.getRows());
			result.setTimes(newResult.getTimes());
			result.setDataList(newResult.getDataList());
			result.setExtDataList(newResult.getExtDataList());
		}
	}
}