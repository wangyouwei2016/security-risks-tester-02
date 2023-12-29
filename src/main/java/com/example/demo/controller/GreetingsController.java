package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.risk.InsecureRandomNumber;
import com.example.demo.risk.HardcodePassword;
import com.example.demo.risk.InsecureThread;
import com.example.demo.risk.BrokenAccessControl;
import com.example.demo.risk.CryptographicFailure;
import com.example.demo.risk.Injection;;

@RestController
public class GreetingsController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hello world! This is a project to test vulnerabilities to test GitHub Enterprise and DevOps platform AS-IS security tools.";
	}
	
	
	@GetMapping("/insecure-random")
	public String insecureRandom() {
		return InsecureRandomNumber.output();
	}
	
	@GetMapping("/hardcode-password")
	public String hardcodePassword() {
		return HardcodePassword.genHardcodePassword();
	}
	
	@GetMapping("/insecure-thread")
	public String insecureThread() {
		InsecureThread.insecureThread();
		return "Insecure threads started.";
	}
	
	@GetMapping("/broken-access-control")
	public String brokenAccessControl(@RequestParam(value = "filePath", defaultValue = "C:\\Users\\u0047367\\hellworld.txt") String filePath) {
		BrokenAccessControl.brokenAccessControl(filePath);
		return "broken ACCESS CONTROL:file written.";
	}	
	@GetMapping("/cryptographicFailure")
	public String brokenAccessControl() throws Exception {
		CryptographicFailure.cryptographicFailure();
		return "unsafe encrypt password";
	}	
	
	@GetMapping("/injection")
	public String injection(@RequestParam(value = "usernamne", defaultValue = "admin") String username,
			@RequestParam(value = "password", defaultValue = "admin123") String password) throws Exception {
		Injection.sqlInjection(username, password);
		return "SQL injection!";
	}	
	
}
