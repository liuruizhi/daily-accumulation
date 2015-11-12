package com.spring.aspectj;


/**
 * 为xml使用的aop类
 * 
 * @author lrz
 *
 */

public class AspectjActionXML {
	
	public void pointCut(){
		System.out.println("waiter ready...");
	}
	
	public void action(){
		System.out.println("waiter ready...");
	}
	
	public void byeAop(){
		System.out.println("clear...");
	}
	
	
	/**
	 * 返回值value与参数value名称一致
	 * 
	 * @param value
	 */
	public void getReturn(Object value){
		System.out.println(value);
	}
	
}
