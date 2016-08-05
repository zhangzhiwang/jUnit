package com.asiainfo;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 某个断言失败将需将推出，即断言失败后面的代码将不再执行
 *
 * @author zhiwangzhang
 * @date 2016年8月5日 下午9:54:35
 */
public class Test3 {
	@Test
	public void test1() {
		int i = 1;
		Assert.assertEquals(i, 1);
		System.out.println("hello");
		Assert.assertEquals(i, 2);
		System.out.println("world");
		Assert.assertEquals(i, 3);
	}
}
