package com.asiainfo;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * per-method和per-suite的setup()/tearDown()
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午11:10:41
 */
public class Test13 extends TestCase {
	public Test13() {}
	
	public Test13(String s) {
		super(s);
	}
	
	public void testAdd() {
		System.out.println("add");
	}
	
	public void testDel() {
		System.out.println("del");
	}
	
	public void testModify() {
		System.out.println("modify");
	}
	
	public void query() {
		System.out.println("query");
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
		testSuite.addTest(new Test13("testAdd"));
		testSuite.addTest(new Test13("testModify"));
		
		TestSetup testSetup = new TestSetup(testSuite){
			@Override
			protected void setUp() {
				System.out.println("suite start...");
			}
			
			@Override
			protected void tearDown() {
				System.out.println("suite end!");
			}
		};
		return testSetup;
	}
}
