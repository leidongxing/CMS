package chapter4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** Performance.perform(..))")
	public void performance() {
		System.out.println("performance do");
	}

	// @Before("performance()")
	// public void silenceCellPhones(){
	// System.out.println("silencing cell phone");
	// }
	//
	// @Before("performance()")
	// public void takeSeats(){
	// System.out.println("Taking seats");
	// }
	//
	// @AfterReturning("performance()")
	// public void applause(){
	// System.out.println("CLAP CLAP CLAP");
	// }
	//
	// @AfterThrowing("performance()")
	// public void demandRefund(){
	// System.out.println("demand a refund");
	// }

	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint p) {
		try {
			System.out.println("do it");
			p.proceed();
		} catch (Throwable e) {
			System.out.println("thorw except");
		}
	}
}
