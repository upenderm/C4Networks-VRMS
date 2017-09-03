package com.c4networks.vrms.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.c4networks.vrms.services.CustomerDetailsService;
import com.c4networks.vrms.services.CustomerDetailsServiceImpl;

public class CustomerDetailsTest {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		try{
		System.out.println("Hello World");
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CustomerDetailsDAO cdi = (CustomerDetailsDAOImpl)ctx.getBean("CustomerDetailsImpl");
		System.out.println("******"+ctx.getApplicationName());
		System.out.println("******"+ctx.getBeanDefinitionNames().length);
		for(String str : ctx.getBeanDefinitionNames()){
			System.out.println(str);
		}
		CustomerDetailsService cds = new CustomerDetailsServiceImpl();
		System.out.println(cds.getCustomers().size());
//		cdi.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
		}
	}

}
