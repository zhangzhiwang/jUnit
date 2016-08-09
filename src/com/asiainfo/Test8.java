package com.asiainfo;

//import junit.framework.Assert;
import junit.framework.TestCase;

//import org.junit.Assert;
import org.junit.Test;

/**
 * 
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午9:31:53
 */
public class Test8 extends TestCase {
	public Test8() {
		super();
	}
	
//	public void test1() {//继承TestCase类后，该类即为测试类，该类中所有以test开头的方法都将被认为是测试方法，而不用在方法头部写@Test
//		assertTrue(true);
//	}
	
//	@Test
	public void addTest() {//该方法不会被认为是测试方法因为它的方法名没有以test开头
		System.out.println("addTest");
		assertTrue(true);
	}
//	
//	public void TestAdd() {//该方法也不会被认为是测试方法，要想被认为是测试方法必须以小写test开头
//		System.out.println("TestAdd");
//	}
	
//	@Test
//	public void removeTest() {
//		System.out.println("removeTest");
//	}
}
