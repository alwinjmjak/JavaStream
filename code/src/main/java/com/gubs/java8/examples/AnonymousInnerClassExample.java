/**
 * 
 */
package com.gubs.java8.examples;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gubs
 *
 */
public class AnonymousInnerClassExample {

	// slf4j is best logging framework which can piggyback any logging implementation
	// Log4j or java.util.logging etc.. Refer : http://saltnlight5.blogspot.com/2013/08/how-to-configure-slf4j-with-different.html
	private static final Logger log = LoggerFactory.getLogger(AnonymousInnerClassExample.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		INames namesInstance = new INames() {
			
			public void sayName(String name) {
				// slf4j supports object[] which will take arguments and replace with {}. 
				// This way the concatenation will happen only if info is enabled 
				// in WARN level the operation will not perform
				log.info("sayName {}", name);
			}
		};
		
		namesInstance.sayName("Gubs Kavi Sai Madhu");
	}
	
}
