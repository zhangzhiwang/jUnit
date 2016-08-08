package com.asiainfo;


import org.junit.Assert;
import org.junit.Test;

/**
 * Assert的常用方法
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午1:37:54
 */
public class Test7 {
	@SuppressWarnings("unused")
	@Test
	public void test1() {
		Assert.assertNull(null);
//		Assert.assertNull("Not null!", new Object());
		Assert.assertNotNull(new Object());
//		Assert.assertNotNull("Is null!", null);
		
		Assert.assertSame(1, 1);//验证两个引用是不是指向同一个对象
//		Assert.assertSame(1, new Integer(1));
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		Integer i3 = i1;
		Assert.assertSame(i1, i3);
//		Assert.assertSame("i1 != i2", i1, i2);
		Assert.assertNotSame(i1, i2);
//		Assert.assertNotSame("i1 == i3", i1, i3);
		
		Assert.assertTrue(true);//这种写法仅为了本测试，实际项目中这行代码是句废话
//		Assert.assertTrue("err!", false);
		Assert.assertFalse(false);
//		Assert.assertFalse("error!",true);
		
		long id = 123;
		if(id > 0) {
			System.out.println("hello");
		} else {
			Assert.fail("id should > 0");//是测试立即失败，在代码不该到的地方使用fail()
		}
		
		try {
			m1();
		} catch(Exception e) {
//			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
		System.out.println("123321");
	}
	
	private void m1() {
		throw new RuntimeException("world");
	}
}
