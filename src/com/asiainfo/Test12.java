package com.asiainfo;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * per-suite的setUp()和tearDown()
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午10:57:46
 */
public class Test12 extends TestCase {
	public Test12() {}
	
	public Test12(String s) {
		super(s);
	}
	
	public void testAdd() {
		System.out.println("testAdd");
	}
	
	public void testDel() {
		System.out.println("testDel");
	}
	
	protected void setUp() {
		System.out.println("方法开始执行...");
	}
	
	protected void tearDown() {
		System.out.println("方法执行结束！");
	}
	
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(new Test12("testDel"));
		
		TestSetup testSetup = new TestSetup(testSuite){
			@Override
			protected void setUp() {
				System.out.println("suite开始执行。。。");
			}
			
			@Override
			public void tearDown() {
				System.out.println("suite执行结束");
			}
		};
		return testSetup;
	}
}
