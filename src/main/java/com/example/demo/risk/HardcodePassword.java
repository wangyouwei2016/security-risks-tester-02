package com.example.demo.risk;


/**
 * 风险点:
 * 1. 代码中硬编码敏感信息
 * 2. 控制台输出敏感数据
 * 
 */
public class HardcodePassword {
	public static String genHardcodePassword() {
		String password = "i_am_a_password!";
		System.out.println("The password is:" + password);
		return password;
	}
}
