package machine.coffee.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PerformanceMonitor {
	@Before(value="(execution(* machine.coffee.handler.RestCallsController.*.*(..)))") 
	//@Before("execution(*machine.coffee.handler.RestCallsController.invokeWebService())")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Before invokeWebService");
	}

	@After("execution(*machine.coffee.handler.RestCallsController.invokeWebService())")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("After invokeWebService");
	}
	@After("execution(*invokeWebService*")
	public void logAfter2(JoinPoint joinPoint) {
		System.out.println("After invokeWebService");
	}

}
