package com.asiainfo;

import junit.framework.TestCase;

/**
 * setUp()和tearDown()
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午10:48:37
 */
public class Test11 extends TestCase {
	protected void setUp() {
		System.out.println("方法开始执行...");
	}
	
	protected void tearDown() {
		System.out.println("方法执行结束！");
	}
	
	public void testAdd() {
		System.out.println("testAdd");
	}
	
	public void testDel() {
		System.out.println("testDel");
	}
}
