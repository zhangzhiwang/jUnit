package com.asiainfo;


import org.junit.Assert;
import org.junit.Test;

/**
 * assertEquals()
 *
 * @author zhiwangzhang
 * @date 2016年8月8日 下午12:44:24
 */
public class Test6 {
	@SuppressWarnings("deprecation")
	@Test
	public void test1() {
		A a1 = new A(1, 1.1);
		A a2 = new A(1, 1.2);
		Assert.assertEquals(a1, a2);//调用的是assertEquals(Object expected, Object actual)，比较对象时，调用的是该对象的equals()方法，即两个对象是不是equals，取决于这个对象的equals()方法是如何定义的
		Assert.assertEquals(1, 1);//assertEquals(long expected, long actual)
		Assert.assertEquals(new Integer(1), new Integer(1));//assertEquals(Object expected, Object actual)
		int i = 1;
		Integer i2 = 1;
//		Assert.assertEquals(i, i2);//The method assertEquals(Object, Object) is ambiguous for the type Assert
		byte b1 = 1;
		byte b2 = 1;
		Assert.assertEquals(b1, b2);//assertEquals(long expected, long actual)
		short s1= 1;
		short s2 = 1;
		Assert.assertEquals(s1, s2);//assertEquals(long expected, long actual)
		Assert.assertEquals('q', 'q');//assertEquals(long expected, long actual)
		Assert.assertEquals(1L, 1L);//assertEquals(long expected, long actual)
		Assert.assertEquals(1.111111f, 1.112222f, 0.01);//assertEquals(double expected, double actual, double delta)，delta为精度
		Assert.assertEquals(1.111111, 1.1111234, 0.1);//assertEquals(double expected, double actual, double delta)
		Assert.assertEquals("Not equals!", 1.1, 1.2, 0.1);
		Assert.assertEquals(true, true);//assertEquals(Object expected, Object actual)
		
//		Assert.assertEquals("When not equals show this.", 2, 1);
//		Assert.assertEquals("When throwing exceptions,will not show this.", 2, m1());
		
//		Assert.assertEquals("Not equal occurs!", new Object(), new Object());
		Assert.assertArrayEquals(new int[]{1,2}, new int[]{1,2});
		Assert.assertEquals(new int[]{1}, new int[]{1});//比较数组时要注意，assertEquals()比较的是两个数组的引用，要想比较数组元素需要使用assertArrayEquals()
	}
	
	private int m1() {
		throw new RuntimeException("hello");
	}
}

class A {
	private int i;
	private double d;
	public A(int i, double d) {
		super();
		this.i = i;
		this.d = d;
	}
	public A() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(d);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		A other = (A) obj;
//		if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d))
//			return false;
		if (i != other.i)
			return false;
		return true;
	}
	
	
}