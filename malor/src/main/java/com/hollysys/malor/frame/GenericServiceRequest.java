package com.hollysys.malor.frame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;

public class GenericServiceRequest extends GenericRequest {

	private static final long serialVersionUID = 6551175701333539091L;

	public GenericServiceRequest() {
	}

	public GenericServiceRequest(Map<String, Object> requestParams,
			Map<String, String> commParams) {
		super(requestParams, commParams);
	}

	public String getServiceCode() {
		return (String) getRequestParams().get("service");
	}

	public String getJsonRequest() {
		Map requests = new HashMap();

		List<Map> reqList = new ArrayList();
		Map reqMap = new HashMap();
		reqMap.put("REQ_MSG_HDR", commParams);
		reqMap.put("REQ_COMM_DATA", requestParams);
		reqList.add(reqMap);

		requests.put("REQUESTS", reqList);
	    return JSON.toJSONString(requests).replaceAll("&quot;", "_webquot;");
	}
}