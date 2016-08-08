package com.asiainfo;

import org.junit.Assert;
import org.junit.Test;

/**
 * assertEquals();
 *
 * @author zhiwangzhang
 * @date 2016年8月6日 上午8:51:07
 */
public class Test5 {
	private int i = 1;
	
	@Test
	public void testM1() {
		Byte b1 = 1;
		byte b2 = 1;
//		Assert.assertEquals(b1, b2);
		Assert.assertEquals(1, 1);
		Assert.assertEquals(new Integer(1), new Integer(1));//比较的是值而不是引用
		Assert.assertFalse(new Integer(1) == new Integer(1));
		// Assert.assertEquals(new Integer(1), 1);//The method assertEquals(Object, Object) is ambiguous for the type Assert
		Assert.assertEquals(1L, 1L);
		Assert.assertEquals(1L, 1);
		Assert.assertEquals(new Character('a'), new Character('a'));
		Assert.assertEquals('a', 'a');
		Assert.assertEquals("123", "123");//比较的是内容而不是引用
		Assert.assertTrue("123" == "123");
		Assert.assertEquals(new String("123"), new String("123"));
		Assert.assertFalse(new String("123") == new String("123"));
//		Assert.assertEquals(new Test5(1), new Test5(1));//实际上调用的是Object的equals()方法
	}

	private int m1() {
		throw new RuntimeException("exception");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test5 other = (Test5) obj;
		if (i != other.i)
			return false;
		return true;
	}
	
	
}
