package com.asiainfo.exercise;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * p60练习1
 *
 * @author zhiwangzhang
 * @date 2016年8月10日 上午8:23:18
 */
public class Exercise_1 extends TestCase {
	private StackExcerciseImpl stackExcerciseImpl;

	public Exercise_1() {
	}

	public Exercise_1(String s) {
		super(s);
	}

	public void testPop() {
		try {
			stackExcerciseImpl.pop();
			fail("Should throw an exception.");
		} catch (StackEmptyException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}

		stackExcerciseImpl.push("hello");
		assertEquals("not equals", 1, stackExcerciseImpl.size());
		assertEquals("not equals", "hello", stackExcerciseImpl.pop());
		assertEquals("not equals", 0, stackExcerciseImpl.size());
		stackExcerciseImpl.push("hello2");
		stackExcerciseImpl.push("hello3");
		assertEquals("not equals", "hello3", stackExcerciseImpl.pop());
		assertEquals("not equals", 1, stackExcerciseImpl.size());
		String s = "world";
		stackExcerciseImpl.push(s);
		assertSame("err", s, stackExcerciseImpl.pop());
		
		try{
		stackExcerciseImpl = new StackExcerciseImpl();
		String s1 = "a";
		String s2 = "b";
		String s3 = "c";
		stackExcerciseImpl.push(s1);
		stackExcerciseImpl.push(s2);
		stackExcerciseImpl.push(s3);
		assertSame("err", s3, stackExcerciseImpl.pop());
		assertSame("err", s2, stackExcerciseImpl.pop());
		assertSame("err", s1, stackExcerciseImpl.pop());
		stackExcerciseImpl.pop();
		fail("Should throw an exception.");
		} catch(StackEmptyException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	}

	public void testTop() {
		try {
			stackExcerciseImpl.top();
		} catch (Exception e) {
		}
	}

	public void testPush() {
		try {
			stackExcerciseImpl.push("");
			fail("Should throw an exception.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}

		try {
			stackExcerciseImpl.push(null);
			fail("Should throw an exception.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}

		try {
			stackExcerciseImpl.push("!@#$%^&*()\\/~`,./");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			fail("Should not throw an exception.");
		}
	}

	public void testIsEmpty() {
		assertTrue(stackExcerciseImpl.isEmpty());
		stackExcerciseImpl.push("a");
		assertFalse(stackExcerciseImpl.isEmpty());
	}
	
	public void testSize() {
		assertEquals("not equals", 0, stackExcerciseImpl.size());
		stackExcerciseImpl.push("a");
		assertEquals("not equals", 1, stackExcerciseImpl.size());
	}
	
	@Override
	protected void setUp() {
		stackExcerciseImpl = new StackExcerciseImpl();
		System.out.println("stackExcerciseImpl初始化完成");
	}

	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(Exercise_1.class);

		TestSetup testSetup = new TestSetup(testSuite) {
			@Override
			protected void setUp() {
				System.out.println("per-suite start...");
			}

			@Override
			protected void tearDown() {
				System.out.println("per-suite end!");
			}
		};
		return testSetup;
	}
}

interface StackExcercise {
	public String pop() throws StackEmptyException;

	public void push(String s);// 需求要求栈元素不能为null或""

	public String top() throws StackEmptyException;

	public boolean isEmpty();

	int size();
}

class StackExcerciseImpl implements StackExcercise {

	@Override
	public String pop() throws StackEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public String top() throws StackEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class StackEmptyException extends RuntimeException {
}