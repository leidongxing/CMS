package com.hollysys.malor.frame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;


public class DataExchangeAssembly {
	private static final String PARAMS_KEY = "params";
	private static final String COMM_PARAMS_KEY = "commParams";
	private static final String CACHES_KEY = "caches";
	private static final String ATTR_KEY = "attr";
	private static final String BUSINESS_CONFIG_KEY = "businessConfig";
	private static final String REQUEST_KEY = "request";
	private static Map<String, Object> globalArea = new ConcurrentHashMap();

	private static final ThreadLocal<Map> businessArea = new ThreadLocal() {
		public Map initialValue() {
			return new HashMap();
		}
	};

	private static final ThreadLocal<Map> service = new ThreadLocal() {
		public Map initialValue() {
			return new HashMap();
		}
	};

	public Object getData(String key) {
		Object data = null;
		if (businessArea != null) {
			data = businessArea.get().get(key);
			if (data != null) {
				return data;
			}
		}
		if (service.get() != null) {
			data = service.get().get(key);
			if (data != null) {
				return data;
			}
		}
		data = globalArea.get(key);
		return data;
	}
	

	public boolean setData(String key, Object value, String scope) {
		if ("business".equals(scope)) {
			setBusinessData(key, value);
		} else if ("service".equals(scope)) {
			setServiceData(key, value);
		} else {
			globalArea.put(key, value);
		}
		return true;
	}

	public static Map<String, Object> getGlobalArea() {
		return globalArea;
	}

	public static void setGlobalArea(Map<String, Object> globalArea) {
		globalArea = globalArea;
	}

	public Map<String, Object> getServiceArea() {
		return (Map) service.get();
	}

	public void setServiceArea(Map<String, Object> serviceArea) {
		service.set(serviceArea);
	}

	public Map<String, Object> getBusinessArea() {
		return (Map) businessArea.get();
	}

	public void setBusinessArea(Map<String, Object> key) {
		businessArea.set(key);
	}

	public Object getBusinessData(String key) {
		return ((Map) businessArea.get()).get(key);
	}

	public Object getGlobalData(String key) {
		return globalArea.get(key);
	}

	public Object getServiceData(String key) {
		return ((Map) service.get()).get(key);
	}


	public boolean setBusinessData(String key, Object value) {
		Map datas = (Map) businessArea.get();
		datas.put(key, value);
		businessArea.set(datas);
		return true;
	}

	public boolean setServiceData(String key, Object value) {
		Map datas = (Map) service.get();
		datas.put(key, value);
		service.set(datas);
		return true;
	}

	public boolean setGlobalData(String key, Object value) {
		return setData(key, value, "global");
	}

	public void startBusiness() {
		businessArea.remove();
	}

	public void endBusiness() {
		businessArea.remove();
	}

	public void startService() {
		service.remove();
	}

	public void endService() {
		service.remove();
	}

	public void clearGlobalArea() {
		globalArea.clear();
	}

	public DataExchangeAssembly setParams(Map params) {
		setBusinessData("params", params);
		return this;
	}

	public Map getParams() {
		return (Map) getBusinessData("params");
	}

	public DataExchangeAssembly setCommParams(Map commParams) {
		setBusinessData("commParams", commParams);
		return this;
	}

	public Map getCommParams() {
		return (Map) getBusinessData("commParams");
	}

	public DataExchangeAssembly setCaches(Map<String, ICache> caches) {
		setBusinessData("caches", caches);
		return this;
	}

	public Map<String, ICache> getCaches() {
		return (Map) getBusinessData("caches");
	}

	public ICache getCache(String cacheKey) {
		if ((null == cacheKey) || ("" == cacheKey)) {
			return null;
		}

		Map<String, ICache> cacheMap = (Map) getBusinessData("caches");
		return (ICache) cacheMap.get(cacheKey);
	}

	public String getSysParam(String paramKey) {
		ICache sysParamCache = getCache("sysParamCache");
		Map paramMap = sysParamCache.getRecord(paramKey);

		if (null == paramMap) {
			return "";
		}

		List<Map> paramList = (List) paramMap.get(paramKey);
		if ((null == paramList) || (paramList.isEmpty())) {
			return "";
		}
		paramMap = (Map) paramList.get(0);
		if (null == paramMap) {
			return "";
		}
		return ObjectUtils.toString(paramMap.get("PAR_VAL"));
	}

	public String getDictText(String dictKey, String dictVal) {
		ICache dictCache = getCache("dictCache");

		Map recMap = dictCache.getRecord(dictKey);
		if (null == recMap) {
			return "";
		}

		List<Map> dictList = (List) recMap.get(dictKey);
		if ((dictList == null) || (dictList.isEmpty())) {
			return "";
		}

		for (Map dictMap : dictList) {
			if (dictVal.equals(ObjectUtils.toString(dictMap.get("DICT_ITEM")))) {
				return ObjectUtils.toString(dictMap.get("DICT_ITEM_NAME"));
			}
		}

		return "";
	}

	public DataExchangeAssembly setAttr(List<String> attr) {
		setBusinessData("attr", attr);
		return this;
	}

	public List<String> getAttr() {
		return (List) getBusinessData("attr");
	}

	private String getAttr(int index)
        {
       List<String> attr = (List)getBusinessData("attr");
       return (index >= 0) && (attr.size() >= index +1 ) ? (String)attr.get(index) : "";
        }

	public String getAttr1() {
		return getAttr(0);
	}

	public String getAttr2() {
		return getAttr(1);
	}

	public String getAttr3() {
		return getAttr(2);
	}

	public String getAttr4() {
		return getAttr(3);
	}

	public DataExchangeAssembly setBusinessConfig(BusinessConfig businessConfig) {
		setBusinessData("businessConfig", businessConfig);
		return this;
	}

	public BusinessConfig getBusinessConfig() {
		return (BusinessConfig) getBusinessData("businessConfig");
	}

	public DataExchangeAssembly setRequest(HttpServletRequest request) {
		setBusinessData("request", request);
		return this;
	}

	public HttpServletRequest getRequest() {
		return (HttpServletRequest) getBusinessData("request");
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public Map<String, String> getOpInfo() {
		return (Map) getSession().getAttribute("USER_INFO");
	}

	public DataExchangeModel getDataExchangeModel() {
		return new DataExchangeModel(this);
	}
}
