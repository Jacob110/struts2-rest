package com.github.yjj.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -6358803554282730952L;
	Logger logger = LogManager.getLogger();

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		String result = null;
		try {
			result = ai.invoke();
		} catch (Exception e) {
			logger.error(ai.toString(), e);
			ai.getStack().push(new ExceptionHolder(e));
			result = "error";
		}
		return result;
	}

}
