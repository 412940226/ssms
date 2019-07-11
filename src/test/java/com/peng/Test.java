package com.peng;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private final static Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		logger.info("logback.info 成功了");
		logger.error("logback.error 成功了");
		logger.debug("logback.debug 成功了");
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(Test.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(Test.class.getResource(""));
		System.out.println(Test.class.getResource("/")); //Class文件所在路径  
		System.out.println(new File("/").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
	}

}
