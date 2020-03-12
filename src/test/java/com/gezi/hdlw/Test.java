package com.gezi.hdlw;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-core.xml", "spring-mvc.xml");

	}

}
