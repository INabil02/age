package ma.ismail.AmazonSES;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ComponentScan(value="ma.ismail.AmazonSES")
@EnableAspectJAutoProxy
public class PerformanceAspect {
	
	@Pointcut("execution(* Test.*(..))")
	public void repositoryClassMethods() {
	};

	@Around("repositoryClassMethods()")
	public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Object returnValue = joinPoint.proceed();
		long end = System.nanoTime();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Execution of " + methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
		return returnValue;
	}
}
