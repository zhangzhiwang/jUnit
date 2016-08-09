package com.asiainfo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * suite()方法
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午10:32:21
 */
public class Test10 extends TestCase {
	public Test10() {}
	
	public Test10(String s) {
		super(s);
	}
	
	public void testNo1() {
		System.out.println("testNo1");
		assertTrue(true);
	}
	
	public void testNo2() {
		System.out.println("testNo2");
		assertTrue(true);
	}
	
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(Test9.class);//运行某测试类的所有测试方法
//		testSuite.addTest(Test9.suite());//运行Test9.suite()方法里面所添加的方法
		testSuite.addTest(new Test10("testNo1"));
		return testSuite;
	}
}
