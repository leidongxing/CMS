package com.hollysys.malor.frame;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MalorBusinessImpl implements IBusiness, ApplicationContextAware {
	private BusinessConfig businessConfig;
	private BeanRegister register;
	private ConfigLoader configLoader;
	private ApplicationContext applicationContext;
	private DataExchangeAssembly dataExchange;

	public void setConfigLoader(ConfigLoader configLoader) {
		this.configLoader = configLoader;
	}

	public BeanRegister getRegister() {
		return register;
	}

	public void setRegister(BeanRegister register) {
		this.register = register;
	}

	public ApplicationContext getApplicationContext()
        {
  53      return applicationContext;
        }

	public void setApplicationContext(ApplicationContext applicationContext) {
  57      this.applicationContext = applicationContext;
        }

	public BusinessConfig getBusinessConfig()
        {
  64      return businessConfig;
        }

	public void setBusinessConfig(BusinessConfig businessConfig) {
  68      this.businessConfig = businessConfig;
        }

	public void setBusinessCode(String businessCode) {
  72      BusinessConfig businessConfig = new BusinessConfig();
  73      businessConfig.setBusinessCode(businessCode);
  74      setBusinessConfig(businessConfig);
        }

	private Method getAtomMethod(Object atomObject, String busMethod,
			String busCode) {
		Method method = null;
		try {
			method = atomObject.getClass().getMethod(busMethod,
					new Class[] { DataExchangeAssembly.class });
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			LogUtil.error(e);
		}
		return method;
	}

	public GenericResult doBusiness(GenericRequest request) {
		return doBusiness(request, businessConfig);
	}

	public GenericResult doBusiness(GenericRequest request,BusinessConfig config) {
		String atomCode = config.getBusinessCode();
		AtomConfigAssembler atomConfig = (AtomConfigAssembler) configLoader
				.getAtomConfigMap().get(atomCode);
		if (atomConfig == null) {
			AtomResult atomResult = new AtomResult();
			atomResult.setFlag("-900000");
			atomResult.setPrompt("没有找到原子业务配置" + atomCode);
			return atomResult;
		}
		String busCode = atomConfig.getCode();
		String busClass = atomConfig.getClazz();
		String busMethod = atomConfig.getMethod();

		List<String> attr = new ArrayList();
		attr.add(null == atomConfig.getAttr1() ? "" : atomConfig.getAttr1());
		attr.add(null == atomConfig.getAttr2() ? "" : atomConfig.getAttr2());
		attr.add(null == atomConfig.getAttr3() ? "" : atomConfig.getAttr3());
		attr.add(null == atomConfig.getAttr4() ? "" : atomConfig.getAttr4());

		if (!busClass.startsWith("com.szkingdom")) {
			busClass = "com.szkingdom.business.atom." + busClass;
		}
		Map<String, ICache> caches = CacheSchedule.getCacheMap();
		Map<String, Object> params = request.getRequestParams();
		Map<String, Object> prop = new HashMap();
		Map commParams = request.getCommParams();
		try {
			dataExchange.setParams(params).setCommParams(commParams)
					.setCaches(caches).setAttr(attr)
					.setBusinessConfig(businessConfig);

			if (null != request.getRequest()) {
				dataExchange.setRequest(request.getRequest());
			}

			Object atomObject = register.addAndReturnBeanService(busCode,
					busClass, prop);
			Method method = getAtomMethod(atomObject, busMethod, busCode);

			DataExchangeAssembly dataExchange2 = new DataExchangeAssembly();
			dataExchange2.setServiceArea(dataExchange.getServiceArea());
			method.setAccessible(true);
			Object result = method.invoke(atomObject,
					new Object[] { dataExchange2 });

			dataExchange.setServiceData("RS_" + busCode, result);

			if ((result instanceof AtomResult)) {
				AtomResult retRs = (AtomResult) result;
				if ((!"0".equals(retRs.getFlag()))
						&& (retRs.getPrompt().indexOf("错误代码:") == -1)) {
					retRs.setPrompt(retRs.getPrompt());
				}
				return (AtomResult) result;
			}
			if ((result instanceof DaoResult)) {
				return (DaoResult) result;
			}
			if ((result instanceof GenericResult)) {
				return (GenericResult) result;
			}
			return new AtomResult((Map) result);
		} catch (InvocationTargetException e) {
			Throwable exception = e.getTargetException();
			if ((exception instanceof AtomException)) {
				LogUtil.error(runtimeException);

				AtomResult atomResult = new AtomResult();
				atomResult.setFlag(String.valueOf(runtimeException
						.getErrorCode()));

				if ("5".equals(runtimeException.getErrorLvl())) {
					atomResult.setPrompt("【效验不合法】："
							+ runtimeException.getMessage());
				} else {
					atomResult.setPrompt(runtimeException.getMessage());
				}
				atomResult.setExStack((Map) dataExchange
						.getServiceData("errorStack"));
				return atomResult;
			}
			LogUtil.error(exception);
			AtomResult atomResult = new AtomResult();
			atomResult.setFlag("-1008");
			atomResult.setPrompt("功能异常，请联系管理员!原子业务异常信息:" + busMethod + "执行异常!");
			return atomResult;
		} catch (Exception e) {
			LogUtil.error(e);
			AtomResult atomResult = new AtomResult();
			atomResult.setFlag("-1008");
			atomResult.setPrompt("功能异常，请联系管理员!原子业务异常信息:" + busMethod + "执行异常!");
			return atomResult;
		}
	}

	public void setDataExchange(DataExchangeAssembly dataExchange) {
		this.dataExchange = dataExchange;
	}
}
