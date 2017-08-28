package com.hollysys.malor.frame;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class LogUtil {
	protected static Log frameLog = LogFactory.getLog(LogUtil.class);

	private static Log getParentLog() {
		try {
			throw new Exception();
		} catch (Exception e) {
			StackTraceElement[] sts = e.getStackTrace();
			for (int i = 0; i < sts.length; i++) {
				try {
					if (Class.forName(sts[i].getClassName()) != LogUtil.class) {
						return LogFactory.getLog(Class.forName(sts[i].getClassName()));
					}
				} catch (ClassNotFoundException e1) {
				}
			}
		}
		return frameLog;
	}
	
	protected static String getLogText(Object o) {
		String requestId = "SYSTEM";
		try {
			RequestAttributes requestAttributes = RequestContextHolder
					.currentRequestAttributes();

			requestId = String.valueOf(requestAttributes.hashCode());
		} catch (IllegalStateException e) {
		}
		if (null == o) {
			return "[" + requestId + "]" + " [日志为空！]";
		}
		if (o instanceof Exception) {
			Exception e = (Exception) o;
			StringBuffer sb = new StringBuffer();
			sb.append(e.getMessage() + "\r\n");
			StackTraceElement[] st = e.getStackTrace();
			for (int i = 0; i < st.length; ++i) {
				sb.append("\t在：" + st[i].getClassName() + "."
						+ st[i].getMethodName() + " 第 " + st[i].getLineNumber()
						+ " 行\r\n");
			}

			return "[" + requestId + "]" + " [" + sb.toString() + "]";
		}
		if (o instanceof String) {
			return "[" + requestId + "]" + " [" + ((String) o) + "]";
		}

		return "[" + requestId + "]" + " [" + String.valueOf(o) + "]";
	}

	public static void info(Log log, Object msg) {
		if (log.isInfoEnabled())
			log.info(getLogText(msg));
	}

	public static void info(Log log, Object msg, Throwable t) {
		if (log.isInfoEnabled())
			log.info(getLogText(msg), t);
	}

	public static void debug(Log log, Object msg) {
		if (log.isDebugEnabled())
			log.debug(getLogText(msg));
	}

	public static void debug(Log log, Object msg, Throwable t) {
		if (log.isDebugEnabled())
			log.debug(getLogText(msg), t);
	}

	public static void error(Log log, Object msg) {
		if (log.isErrorEnabled())
			log.error(getLogText(msg));
	}

	public static void error(Log log, Object msg, Throwable t) {
		if (log.isErrorEnabled())
			log.error(getLogText(msg), t);
	}

	public static void fatal(Log log, Object msg) {
		if (log.isFatalEnabled())
			log.fatal(getLogText(msg));
	}

	public static void fatal(Log log, Object msg, Throwable t) {
		if (log.isFatalEnabled())
			log.fatal(getLogText(msg), t);
	}

	public static void warn(Log log, Object msg) {
		if (log.isWarnEnabled())
			log.warn(getLogText(msg));
	}

	public static void warn(Log log, Object msg, Throwable t) {
		if (log.isWarnEnabled())
			log.warn(getLogText(msg), t);
	}

	public static void info(Class<?> c, Object msg) {
		info(LogFactory.getLog(c), msg);
	}

	public static void info(Class<?> c, Object msg, Throwable t) {
		info(LogFactory.getLog(c), msg, t);
	}

	public static void debug(Class<?> c, Object msg) {
		debug(LogFactory.getLog(c), msg);
	}

	public static void debug(Class<?> c, Object msg, Throwable t) {
		debug(LogFactory.getLog(c), msg, t);
	}

	public static void error(Class<?> c, Object msg) {
		error(LogFactory.getLog(c), msg);
	}

	public static void error(Class<?> c, Object msg, Throwable t) {
		error(LogFactory.getLog(c), msg, t);
	}

	public static void fatal(Class<?> c, Object msg) {
		fatal(LogFactory.getLog(c), msg);
	}

	public static void fatal(Class<?> c, Object msg, Throwable t) {
		fatal(LogFactory.getLog(c), msg, t);
	}

	public static void warn(Class<?> c, Object msg) {
		warn(LogFactory.getLog(c), msg);
	}

	public static void warn(Class<?> c, Object msg, Throwable t) {
		warn(LogFactory.getLog(c), msg, t);
	}

	public static void info(Object msg) {
		info(getParentLog(), msg);
	}

	public static void info(Object msg, Throwable t) {
		info(getParentLog(), msg, t);
	}

	public static void debug(Object msg) {
		debug(getParentLog(), msg);
	}

	public static void debug(Object msg, Throwable t) {
		debug(getParentLog(), msg, t);
	}

	public static void error(Object msg) {
		error(getParentLog(), msg);
	}

	public static void error(Object msg, Throwable t) {
		error(getParentLog(), msg, t);
	}

	public static void fatal(Object msg) {
		fatal(getParentLog(), msg);
	}

	public static void fatal(Object msg, Throwable t) {
		fatal(getParentLog(), msg, t);
	}

	public static void warn(Object msg) {
		warn(getParentLog(), msg);
	}

	public static void warn(Object msg, Throwable t) {
		warn(getParentLog(), msg, t);
	}

	public static boolean isDebugEnabled(Log log) {
		return log.isDebugEnabled();
	}

	public static boolean isErrorEnabled(Log log) {
		return log.isErrorEnabled();
	}

	public static boolean isFatalEnabled(Log log) {
		return log.isFatalEnabled();
	}

	public static boolean isInfoEnabled(Log log) {
		return log.isInfoEnabled();
	}

	public static boolean isErrorEnabled(Class<?> c) {
		return LogFactory.getLog(c).isErrorEnabled();
	}

	public static boolean isFatalEnabled(Class<?> c) {
		return LogFactory.getLog(c).isFatalEnabled();
	}

	public static boolean isInfoEnabled(Class<?> c) {
		return LogFactory.getLog(c).isInfoEnabled();
	}

	public static boolean isDebugEnabled() {
		return getParentLog().isDebugEnabled();
	}

	public static boolean isErrorEnabled() {
		return getParentLog().isErrorEnabled();
	}

	public static boolean isFatalEnabled() {
		return getParentLog().isFatalEnabled();
	}

	public static boolean isInfoEnabled() {
		return getParentLog().isInfoEnabled();
	}
}