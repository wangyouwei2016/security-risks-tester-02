package com.example.demo.risk;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * 
 * 风险点: 多线程向 ARRAYLIST添加元素.arraylist是线程不安全的类型.
 */

public class InsecureThread {
	public static void insecureThread() {
		List<String> list = new ArrayList<>();
		for(int i=0; i<30; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,8));
			}		
		    ).start();
		}
		
	}
}
