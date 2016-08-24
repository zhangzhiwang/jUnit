package com.asiainfo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Exercise_5.java
 * @Description: p62练习5
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年8月24日 下午8:06:28
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年8月24日 zhangzw8 v1.0.0 创建
 */
public class Exercise_5 extends TestCase {
	private F f;

	public Exercise_5() {
	}

	public Exercise_5(String name) {
		super(name);
	}

	@Override
	protected void setUp() {
		System.out.println("per-method start...");
		f = new F(100.0f);
	}

	@Override
	protected void tearDown() {
		System.out.println("per-method end!");
	}

	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(Exercise_5.class);

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

	public void testFastForward() {
		try {
			f.fastForward(0);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			f.fastForward(-1);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}

		f.fastForward(f.getEot());
		assertTrue(f.isEnd());

		f.fastForward(f.currTimePos() + (f.getEot() - f.currTimePos()));
		assertTrue(f.isEnd());
	}

	public void testRewind() {
		try {
			f.rewind(0);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			f.rewind(-1);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}

		f.rewind(f.getEot());
		assertTrue(f.isBegin());

		f.rewind(f.currTimePos() + (f.getEot() - f.currTimePos()));
		assertTrue(f.isBegin());
	}

	public void testCurrTimePos() {
		assertTrue(f.currTimePos() >= 0.0f);
		assertTrue(f.currTimePos() <= f.getEot());
	}

	public void testMark() {
		try {
			f.mark(null);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			f.mark("");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}

		f.mark("123");
		assertEquals(1, f.getMarkMap().size());
		f.mark("123");
		assertEquals(1, f.getMarkMap().size());
		f.mark("1234");
		assertEquals(2, f.getMarkMap().size());
		f.mark("1234");
		assertEquals(2, f.getMarkMap().size());

	}

	public void testGoToMark() {
		try {
			f.goToMark(null);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			f.goToMark("");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}

interface E {
	void fastForward(float sec);

	void rewind(float sec);

	float currTimePos();

	void mark(String name);

	void goToMark(String name);
}

class F implements E {
	private float eot;
	private boolean isEnd;
	private boolean isBegin;
	private Map<String, Float> markMap = new HashMap<String, Float>();

	public F() {
	}

	public F(float f) {
		f = eot;
	}

	public Map<String, Float> getMarkMap() {
		return markMap;
	}

	public void setMarkMap(Map<String, Float> markMap) {
		this.markMap = markMap;
	}

	public boolean isBegin() {
		return isBegin;
	}

	public void setBegin(boolean isBegin) {
		this.isBegin = isBegin;
	}

	public float getEot() {
		return eot;
	}

	public void setEot(float eot) {
		this.eot = eot;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	@Override
	public void fastForward(float sec) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rewind(float sec) {
		// TODO Auto-generated method stub

	}

	@Override
	public float currTimePos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mark(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void goToMark(String name) {
		// TODO Auto-generated method stub

	}
}