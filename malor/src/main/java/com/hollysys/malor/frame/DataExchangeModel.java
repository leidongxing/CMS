package com.hollysys.malor.frame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

public class DataExchangeModel {
	private Map params;
	private Map commParams;
	private Map<String, ICache> cacheMap;
	private List<String> attr;
	private BusinessConfig businessConfig;

	public DataExchangeModel(DataExchangeAssembly dataExchange) {
		params = dataExchange.getParams();
		commParams = dataExchange.getCommParams();
		cacheMap = dataExchange.getCaches();
		attr = dataExchange.getAttr();
		businessConfig = dataExchange.getBusinessConfig();
	}

	public Map getParams() {
		return null != params ? params : new HashMap();
	}

	public Map getCommParams() {
		return null != commParams ? commParams : new HashMap();
	}

	public ICache getCache(String cacheKey) {
		if ((null == cacheKey) || ("" == cacheKey)) {
			return null;
		}
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

	private String getAttr(int index) {
		return (index >= 0) && (attr.size() >= index + 1) ? (String) attr
				.get(index) : "";
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

	public BusinessConfig getBusinessConfig() {
		return businessConfig;
	}
}