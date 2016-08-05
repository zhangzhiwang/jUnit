package com.asiainfo;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 要用断言而不用System.out.println();
 *
 * @author zhiwangzhang
 * @date 2016年8月5日 下午9:36:56
 */
public class Test1 {
	
	@Test
	public void test1() {
//		System.out.println(insert());//要用断言
		Assert.assertTrue(insert() == 1);
	}
	
	private int insert() {
		return 1;
	}
}
