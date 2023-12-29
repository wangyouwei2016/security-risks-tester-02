package com.example.demo.risk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * A01:2021-Broken Access Control 
 * 风险点： 对文件路径不做安全校验, 入侵者可以利用这个缺陷攻击系统
 */
public class BrokenAccessControl {
	public static void brokenAccessControl(String filePath) {
		String content = "Hello, world!"; // 未进行输入校验和合法性检查，可任意写入内容  
		try {  
		    FileWriter writer = new FileWriter(new File(filePath));  
		    writer.write(content);  
		    writer.close();  
		    System.out.println("写入成功！");  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    } 	
		}
}
