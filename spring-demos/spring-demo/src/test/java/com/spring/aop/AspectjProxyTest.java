package com.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.aspectj.AspectjAction;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class AspectjProxyTest {
	
	@Autowired
	ApplicationContext applicationContext;
	
	AopAction aopAction = new AopAction();
	AspectJProxyFactory factory = new AspectJProxyFactory();
	
	/**
	 * 测试①，简单测试，不涉及配置文件
	 */
	@Test
	public void test1(){
		factory.setTarget(aopAction);
		factory.addAspect(AspectjAction.class);
		AopAction proxy = factory.getProxy();
		
		proxy.welcome();
		proxy.bye();
	}
	
	/**
	 * 测试②
	 * 只是用xml配置，且未用aop命名空间
	 */
	@Test
	public void test2(){
		AopAction aopAction = (AopAction)applicationContext.getBean("aopAction");
		aopAction.welcome();
	}
	
	/**
	 * 测试③
	 * 只是用xml配置，用aop命名空间
	 */
	@Test
	public void test3(){
		AopAction aopAction = (AopAction)applicationContext.getBean("aopAction");
		aopAction.welcome();
	}
	
	/**
	 * 测试④
	 */
	@Test
	public void test4(){
		AopAction aopAction = (AopAction)applicationContext.getBean("aopAction");
		aopAction.bye();
	}
}
