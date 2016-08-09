package com.asiainfo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * suit()方法
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午10:13:06
 */
public class Test9 extends TestCase {
//	public Test9() {}
//	
//	public Test9(String s) {
//		super(s);
//	}
	
	public void testAdd() {
		System.out.println("testAdd");
		assertEquals(2, 1+1);
	}
	
	public void testSub() {
		System.out.println("testSub");
		assertEquals(0, 1-1);
	}
	
	public void testMul() {
		System.out.println("testMul");
		assertEquals(1, 1*1);
	}
	
//	public static Test suite() {//注：该方法名称固定为suite
//		TestSuite suite = new TestSuite();
//		suite.addTest(new Test9("testAdd"));//运行testAdd()方法
////		suite.addTest(new Test9("testMul"));//往suite里面加入哪个方法就执行哪个方法，如果不写suite()方法，那么默认执行所有测试方法
//		return suite;
//	}
}
