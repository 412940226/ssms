package com.peng.exception;

/**
 * 
* @ClassName: CustomExceptionHandler 
* @Description: 自定义全局异常 
* @author pengcq 412940226@qq.com 
* @date 2017年6月16日 下午8:50:01 
*
 */
public class CustomExceptionHandler extends RuntimeException {

	public CustomExceptionHandler() {
		super();
	}

	public CustomExceptionHandler(String msg, Throwable exception) {
		super(msg, exception);
	}

}
