package com.hollysys.malor.frame;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BusinessInstance implements ApplicationContextAware {
	private ApplicationContext applicationContext = null;

	private BusinessFactory businessFactory = null;

	public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void initSetUp() {
		businessFactory = ((BusinessFactory) applicationContext.getBean("businessFactory"));
	}

	public GenericResult callBusiness(String code, Map requestParams,Map commParams, int businessType,Map<Thread, DataExchangeAssembly> dataExchanges) {
		Thread current = Thread.currentThread();
		DataExchangeAssembly dataExchange = (DataExchangeAssembly) dataExchanges.get(current);
		return callBusiness(code, requestParams, commParams, businessType,dataExchange);
	}

	public GenericResult callBusiness(String code, Map requestParams,Map commParams, int businessType, DataExchangeAssembly dataExchange) {
		GenericResult bussResult = null;
		try {
			IBusiness business = businessFactory.getBusinessInstance(businessType);
			BusinessConfig businessConfig = new BusinessConfig();
			businessConfig.setBusinessCode(code);
			business.setBusinessConfig(businessConfig);
			GenericRequest genericRequest = new GenericRequest();
			genericRequest.setRequestParams(requestParams);
			genericRequest.setCommParams(commParams);
			if (dataExchange != null) {
				business.setDataExchange(dataExchange);
			}
			bussResult = business.doBusiness(genericRequest, businessConfig);

		} catch (MalorException e) {

			bussResult = new GenericResult(e.getErrorCode(), e.getMessage());
		} catch (Exception e) {
			LogUtil.error("原子业务调用异常", e);
			bussResult = new GenericResult("-1008", "原子业务调用异常,初始化BEX业务实例类异常");
		}
		return bussResult;
	}
}
