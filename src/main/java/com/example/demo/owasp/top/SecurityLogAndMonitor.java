package com.example.demo.owasp.top;

import java.util.logging.*;

/**
 * Returning to the OWASP Top 10 2021, this category is to help detect, escalate, and respond to active breaches. Without logging and monitoring, breaches cannot be detected. Insufficient logging, detection, monitoring, and active response occurs any time:
 * 
 */
public class SecurityLogAndMonitor {
	private static final Logger logger = Logger.getLogger(SecurityLogAndMonitor.class.getName());
	
	public static void sensitiveLog() {
		String username = "user1";
		String country = "America";
		logger.info("Username: " + username + ", country: " + country);
	}

}
