package org.springframework.samples.petclinic.util;

import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Spring Interceptor whose role is to set MDC context for the key request/session context values like IP, Principal, etc..
 * This is configured in the <code>mvc-core-config.xml</code> like so:
 * <pre>
 * <mvc:interceptors>
 *   <bean class="org.springframework.samples.petclinic.util.LogInterceptor" />
 * </mvc:interceptors>
 * </pre>
 * @author hoserdude
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
	
	public static final String START_TIME = "startTime";
	public static final String PRINCIPAL2 = "principal";
	public static final String ANONYMOUS = "anonymous";
	public static final String IP_ADDRESS = "ipAddress";
	public static final String REQUEST_ID = "requestId";
	public static final String SESSION_ID = "sessionId";
	
	final static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute(START_TIME, startTime);
		
		//Set MDC Context
		String sessionId = request.getSession().getId();
		MDC.put(SESSION_ID, sessionId);
		String requestId = String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()));
		MDC.put(REQUEST_ID, requestId);
		String ipAddress = IpUtils.getIpFromRequest(request);
		MDC.put(IP_ADDRESS, ipAddress);
		Principal principal = request.getUserPrincipal();
		String principalName = ANONYMOUS;
		if (principal != null) {
			principalName = principal.getName();
		} 
		MDC.put(PRINCIPAL2, principalName);


		return true;
	}
	
	@Override
	public void afterCompletion(
		HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
 
		long startTime = (Long)request.getAttribute(START_TIME);
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		
		logger.info("method=" + request.getMethod() + "; time=" + executeTime);
	}
}
