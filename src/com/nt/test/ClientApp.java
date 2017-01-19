package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.aspect.PerformanceMonitoringAdvice;
import com.nt.target.ArithmeticService;

public class ClientApp {

	public static void main(String[] args) {

		ProxyFactory factory = null;
		ArithmeticService proxy = null;
		PerformanceMonitoringAdvice pmAdvice = null;
		// create the ProxyFactory obj

		factory = new ProxyFactory();
		/*
		 * //create the target class obj proxy =new ArithmeticService();
		 * 
		 * //create the advice class obj pmAdvice=new
		 * PerformanceMonitoringAdvice();
		 */

		factory.setTarget(new ArithmeticService());
		factory.addAdvice(new PerformanceMonitoringAdvice());

		// get proxy class object
		proxy = (ArithmeticService) factory.getProxy();

		// get the all info about proxy class

		System.out.println("proxy class " + proxy.getClass());

		// call business methods
		System.out.println("Addition  " + proxy.add(12, 23));
		System.out.println("======================");
		System.out.println("subtraction  " + proxy.sub(23, 12));
		System.out.println("======================");
		System.out.println("multiplication " + proxy.mul(10, 12));
		System.out.println("======================");
		System.out.println("division  " + proxy.div(23, 22));

	}

}
