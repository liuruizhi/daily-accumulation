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
	 * ���Ԣ٣��򵥲��ԣ����漰�����ļ�
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
	 * ���Ԣ�
	 * ֻ����xml���ã���δ��aop�����ռ�
	 */
	@Test
	public void test2(){
		AopAction aopAction = (AopAction)applicationContext.getBean("aopAction");
		aopAction.welcome();
	}
	
	/**
	 * ���Ԣ�
	 * ֻ����xml���ã���aop�����ռ�
	 */
	@Test
	public void test3(){
		AopAction aopAction = (AopAction)applicationContext.getBean("aopAction");
		aopAction.welcome();
	}
	
	/**
	 * ���Ԣ�
	 */
	@Test
	public void test4(){
		AopAction aopAction = (AopAction)applicationContext.getBean("aopAction");
		aopAction.bye();
	}
}
