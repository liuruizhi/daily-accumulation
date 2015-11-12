package com.spring.aspectj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * The parameters pattern is slightly more complex: () matches a method that takes no parameters, 
 * whereas (..) matches any number of parameters (zero or more). 
 * The pattern (*) matches a method taking one parameter of any type, 
 * (*,String) matches a method taking two parameters, the first can be of any type, the second must be a String. 
 * 
 * @author lrz
 *
 */

@Aspect
public class AspectjAction {
	
	@Pointcut("execution(* welcome(..))")
	public void pointCut(){
		System.out.println("waiter ready...");
	}
	
	@Before("pointCut()")
	public void action(){
		System.out.println("waiter ready...");
	}
	
	@After("execution(* bye(..))")
	public void byeAop(){
		System.out.println("clear...");
	}
	
//	action()/byeAop()应为@PointCut
//	@Before("action() && byeAop()")
//	public void Max(){
//		System.out.println("end..");
//	}
	
	/**
	 * 返回值value与参数value名称一致
	 * 
	 * @param value
	 */
	@AfterReturning(pointcut="pointCut()", returning="value")
	public void getReturn(Object value){
		System.out.println(value);
	}
	
}
