package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.codeqa.HardcodePassword;
import com.example.demo.codeqa.InsecureRandomNumber;
import com.example.demo.codeqa.InsecureThread;
import com.example.demo.owasp.a01_brokenAccessControl.ImproperLimitationPathname;
import com.example.demo.owasp.top.BrokenAccessControl;
import com.example.demo.owasp.top.CryptographicFailure;
import com.example.demo.owasp.top.DataIntegrityFailures;
import com.example.demo.owasp.top.IdentificationAuthenticationFailures;
import com.example.demo.owasp.top.Injection;
import com.example.demo.owasp.top.InsecureDesign;
import com.example.demo.owasp.top.SecurityLogAndMonitor;
import com.example.demo.owasp.top.SecurityMisconfiguration;
import com.example.demo.owasp.top.ServerSideRequestForgery;
import com.example.demo.owasp.top.VulnerableOutdatedComponents;

@RestController
public class GreetingsController {
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "hello world! This is a project to test vulnerabilities to test GitHub Enterprise and DevOps platform AS-IS security tools.";
	}
	

	
	@GetMapping("/broken-access-control")
	public String brokenAccessControl(@RequestParam(value = "filePath", defaultValue = "C:\\Users\\u0047367\\hellworld.txt") String filePath) {
		BrokenAccessControl.brokenAccessControl(filePath);
		return "A01:broken ACCESS CONTROL:file written.";
	}	
	@GetMapping("/cryptographicFailure")
	public String brokenAccessControl() throws Exception {
		CryptographicFailure.cryptographicFailure();
		return "A02:unsafe encrypt password";
	}	
	
	@GetMapping("/injection")
	public String injection(@RequestParam(value = "usernamne", defaultValue = "admin") String username,
			@RequestParam(value = "password", defaultValue = "admin123") String password) throws Exception {
		Injection.sqlInjection(username, password);
		return "A03:injection!";
	}	

	@GetMapping("/insecure-design")
	public String insecureDesign(){
	    InsecureDesign.insecureDesign();
		return "A04:2021 – Insecure Design";
	}
	
	@GetMapping("/security-misconfig")
	public String securityMisconfig(){
		SecurityMisconfiguration.securityMisconfiguration();
		return "A05:2021 – Security Misconfiguration";
	}
	@GetMapping("/outdated-component")
	public String outdatedComp() throws IOException{
		VulnerableOutdatedComponents.vulnerableOutdatedComponents();
		return "A06:2021-Vulnerable and Outdated Components";
	}
	

	@GetMapping("/identify-auth")
	public String identifyAndAuth(@RequestParam(value = "username", defaultValue = "admin") String userName){
		IdentificationAuthenticationFailures.authenticate(userName);
		IdentificationAuthenticationFailures.isAdmin(userName);
		return "A07:2021-Identification and Authentication Failure";
	}
	
	@GetMapping("/data-integrity")
	public String dataIntegrity() throws Exception{
		DataIntegrityFailures.dataIntegrityFailure();
		return "A08:2021-Software and Data Integrity Failures";
	}
	
	@GetMapping("/sensitve-log")
	public String sensitiveLog() throws Exception{
		SecurityLogAndMonitor.sensitiveLog();
		return "A09:Security log and monitoring";
	}
	
	@GetMapping("/ssrf")
	public String ssrf(){
		ServerSideRequestForgery.ssrf();
		return "A10:SSRF";
	}
	
	@GetMapping("/path-traversal")
	public String pathTraversal(@RequestParam(value = "filePath", defaultValue = "/safe_dir/") String filePath){
		ImproperLimitationPathname.improperLimitationPathname("/safe_dir/../important.dat");
		return "CWE-22: Improper Limitation of a Pathname to a Restricted Directory ('Path Traversal')";
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
}
