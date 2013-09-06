package org.springframework.samples.petclinic.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Aspect that gets into the business of any class or method annotated with the {@link Instrumentable} annotation. 
 * Configuration is in the <code>tools-config.xml</code> file, like so:
 * <pre>
 * <bean id="logAspect" class="org.springframework.samples.petclinic.util.LogAspect"/>
 * <aop:config>
 * 		<aop:aspect id="instrumentationLogging" ref="logAspect">
 *	      <aop:pointcut id="allInterfaceMethods" expression="@annotation(org.springframework.samples.petclinic.util.Instrumentable)"/>
 *	      <aop:around pointcut-ref="allInterfaceMethods" method="profile"/>
 *	   </aop:aspect>
 *	</aop:config>
 *	</pre>
 * @author hoserdude
 */
@Aspect
public class LogAspect {
	final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	public Object profile(ProceedingJoinPoint call) throws Throwable {

		long startTime = System.currentTimeMillis();
		try {
			return call.proceed();
		} finally {
			long endTime = System.currentTimeMillis();
			long executeTime = endTime - startTime;

			final Signature sig = call.getSignature();
			final String declaringTypeName = sig.getDeclaringTypeName();
			final String methodName = sig.getName();
			final String operation = declaringTypeName + "." + methodName;

			logger.info("operation=" + operation + "; time=" + executeTime);
		}
	}
}
