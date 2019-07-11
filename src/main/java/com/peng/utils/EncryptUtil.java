package com.peng.utils;

import java.io.Serializable;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 
* @ClassName: EncryptUtil 
* @Description: TODO(commons-codec commons-lang 常用加密算法工具类) 
* @author pengcq 412940226@qq.com 
* @date 2017年6月29日 下午6:52:56 
*
 */
public class EncryptUtil implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	
	public static String encodeMD5Str(String str){
		if (StringUtils.isEmpty(str)) {
			return null;
		}
		return DigestUtils.md5Hex(str);
	}
	public static void main(String[] args) {
		String str=encodeMD5Str("admin");
		System.out.println(str);
	}
}
