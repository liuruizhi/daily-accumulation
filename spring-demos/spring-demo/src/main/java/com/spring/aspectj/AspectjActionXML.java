package com.spring.aspectj;


/**
 * Ϊxmlʹ�õ�aop��
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
	 * ����ֵvalue�����value����һ��
	 * 
	 * @param value
	 */
	public void getReturn(Object value){
		System.out.println(value);
	}
	
}
