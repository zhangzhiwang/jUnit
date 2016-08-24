package com.asiainfo.exercise;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Exercise_3.java
 * @Description: p62练习3
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年8月24日 上午9:11:31
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016年8月24日     zhangzw8           v1.0.0               创建
*/
public class Exercise_3 extends TestCase {
	public Exercise_3() {}
	
	public Exercise_3(String s) {
		super(s);
	}
	@Override
	protected void setUp() {
		System.out.println("per-method start...");
	}
	
	@Override
	protected void tearDown() {
		System.out.println("per-method end!");
	}
	
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(new Exercise_3("testSendFax"));
		
		TestSetup testSetup = new TestSetup(testSuite){
			@Override
			protected void setUp() {
				System.out.println("per-suite start...");
			}
			
			@Override
			protected void tearDown() {
				System.out.println("per-suite end!");
			}
		};
		
		return testSetup;
	}
	
	public void testSendFax() {
		B b = new B();
		try{
			b.sendFax(null, "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("12", null);
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof MissingOrBadFileException);
		}
		try{
			b.sendFax("12", "");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof MissingOrBadFileException);
		}
		try{
			b.sendFax("12345678901", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("123", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("abc", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("!@#$%^&", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("123-4567890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("123-4567-890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("123-4567-890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("123-456-7890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		try{
			b.sendFax("023-456-7890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneFormatException);
		}
		//需求：x11/x9n/37n/96n指的是号码的第一部分
		try{
			b.sendFax("211-456-7890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneAreaCodeException);
		}
		try{
			b.sendFax("291-456-7890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneAreaCodeException);
		}
		try{
			b.sendFax("371-456-7890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneAreaCodeException);
		}
		try{
			b.sendFax("961-456-7890", "12");
			fail();
		} catch(Exception e) {
			assertTrue(e instanceof PhoneAreaCodeException);
		}
		
		assertTrue(b.sendFax("223-456-7890", "12"));
	}
}

interface A {
	boolean sendFax(String phone, String fileName) throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException;
}

class B implements A {

	@Override
	public boolean sendFax(String phone, String fileName) throws MissingOrBadFileException, PhoneFormatException, PhoneAreaCodeException {
		// TODO Auto-generated method stub
		return false;
	}}

class MissingOrBadFileException extends RuntimeException {}

class PhoneFormatException extends RuntimeException {}

class PhoneAreaCodeException extends RuntimeException {}
