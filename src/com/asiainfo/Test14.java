package com.asiainfo;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 自定义JUnit断言（自定义测试基类）
 *
 * @author zhiwangzhang
 * @date 2016年8月9日 上午8:14:30
 */
public class Test14 extends B {
	public void testAdd() {
		System.out.println("testAdd");
	}
}

class B extends TestCase {
//	@Override
//	protected void setUp() {
//		System.out.println("per-method start...");
//	}
//	
//	@Override
//	protected void tearDown() {
//		System.out.println("per-method end!");
//	}
//	
//	public static Test suite() {
//		TestSuite testSuite = new TestSuite();
//		testSuite.addTestSuite(Test14.class);
//		TestSetup testSetup = new TestSetup(testSuite){
//			@Override
//			protected void setUp() {
//				System.out.println("per-suite start...");
//			}
//			
//			@Override
//			protected void tearDown() {
//				System.out.println("per-suite end!");
//			}
//		};
//		
//		return testSetup;
//	}
}