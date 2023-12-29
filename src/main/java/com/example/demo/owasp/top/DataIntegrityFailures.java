package com.example.demo.owasp.top;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 
 * A new category for 2021 focuses on making assumptions related to software updates, critical data, and CI/CD pipelines without verifying integrity. One of the highest weighted impacts from Common Vulnerability and Exposures/Common Vulnerability Scoring System (CVE/CVSS) data. Notable Common Weakness Enumerations (CWEs) include CWE-829: Inclusion of Functionality from Untrusted Control Sphere, CWE-494: Download of Code Without Integrity Check, and CWE-502: Deserialization of Untrusted Data.
 */
public class DataIntegrityFailures {
	public static void dataIntegrityFailure() throws IOException, ClassNotFoundException {
		/**
		 * This code snippet deserializes an object from a file and uses it as a UI button:


		 * 
		 * This code does not attempt to verify the source or contents of the file before deserializing it. An attacker may be able to replace the intended file with a file that contains arbitrary malicious code which will be executed when the button is pressed.

			To mitigate this, explicitly define final readObject() to prevent deserialization. An example of this is:
		 * 
		 * 
		 */
		try {
			File file = new File("object.obj");
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			@SuppressWarnings("unused")
			javax.swing.JButton button = (javax.swing.JButton) in.readObject();
			in.close();
		}
		finally{

		}
	}
}
