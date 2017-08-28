package com.hollysys.malor.frame;

import java.util.HashMap;
import java.util.Map;

public class MalorException extends FrameRuntimeException{
	
	private static final long serialVersionUID = -880758585501717621L;

	public MalorException(int errorCode, String message, String lvl) {
		this(errorCode, message, lvl, null);
	}

	public MalorException(int errorCode, String message, String lvl,
			String[] params) {
		super(message);
		setErrorCode(errorCode);
		setErrorLvl(lvl);
		new ErrorStack(errorCode, message, lvl, params);
	}

	public MalorException(DataExchangeAssembly dataExchange, int errorCode,
			String message, String lvl) {
		this(dataExchange, errorCode, message, lvl, null);
	}

	public MalorException(DataExchangeAssembly dataExchange, int errorCode,
			String message, String lvl, String[] params) {
		super(message);
		setErrorCode(errorCode);
		ErrorStack es = new ErrorStack(errorCode, message, lvl,params);
		LogUtil.error("原子业务异常,异常信息:" + es);
		addExceptionStack(dataExchange, lvl, es);
	}

	public void addExceptionStack(DataExchangeAssembly dataExchange,
			String lvl, ErrorStack es) {
		Map<String,ErrorStack> stack = (Map<String,ErrorStack>) dataExchange.getServiceData("errorStack");

		if (stack == null) {
			stack = new HashMap();
			dataExchange.setServiceData("errorStack", stack);
		}
		stack.put(lvl, es);
	}

}
