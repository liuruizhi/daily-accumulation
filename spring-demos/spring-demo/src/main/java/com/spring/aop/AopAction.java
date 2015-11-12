package com.spring.aop;

public class AopAction {
	
	public String welcome(){
		System.out.println("Hello, sir.");
		return "hello";
	}
	
	public void bye(){
		System.out.println("Bye sir.");
	}
	
	public void sleep(){
		System.out.println("sleep");
	}
}
