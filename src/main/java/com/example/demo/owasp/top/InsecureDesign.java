package com.example.demo.owasp.top;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A04:2021 – Insecure Design
 * CWE-311: Missing Encryption of Sensitive Data
 * The following code attempts to establish a connection to a site to communicate sensitive information.
   Though a connection is successfully made, the connection is unencrypted and it is possible that all sensitive data sent to or received from the server will be read by unintended actors.


 * 
 */
public class InsecureDesign {
	public static void insecureDesign() {
		try {
			URL u = new URL("http://www.secret.example.org/");
			HttpURLConnection hu = (HttpURLConnection) u.openConnection();
			hu.setRequestMethod("PUT");
			hu.connect();
			OutputStream os = hu.getOutputStream();
			hu.disconnect();
			}
			catch (IOException e) {

			//...
			}
	}
}
