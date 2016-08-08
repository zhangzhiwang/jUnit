package com.asiainfo;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 某个测试方法抛出了异常（或assert失败），该测试方法将退出，但不会影响其它的测试方法运行
 *
 * @author zhiwangzhang
 * @date 2016年8月6日 上午8:44:43
 */
public class Test4 {
	@Test
	public void testM1() {
//		m1();
		Assert.assertTrue(1 == 2);
		System.out.println("hello");
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(1 == 1);
		System.out.println("world");
	}
	
	private void m1() {
		throw new RuntimeException();
	}
}
