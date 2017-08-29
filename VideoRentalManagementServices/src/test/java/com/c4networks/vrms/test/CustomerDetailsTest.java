package com.c4networks.vrms.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.c4networks.vrms.services.dao.CustomerDetailsDAO;
import com.c4networks.vrms.services.dao.CustomerDetailsDAOImpl;

public class CustomerDetailsTest {

	public static void main(String[] args) {
		try{
		System.out.println("Hello World");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CustomerDetailsDAO cdi = (CustomerDetailsDAOImpl)ctx.getBean("CustomerDetailsImpl");
		System.out.println("******"+ctx.getApplicationName());
		System.out.println("******"+ctx.getBeanDefinitionNames().length);
		for(String str : ctx.getBeanDefinitionNames()){
			System.out.println(str);
		}
//		cdi.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
