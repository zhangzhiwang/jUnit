package com.asiainfo.exercise;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Exercise_4.java
 * @Description: p62练习4
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年8月24日 上午9:48:52
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年8月24日 zhangzw8 v1.0.0 创建
 */
public class Exercise_4 extends TestCase {
	private float tableX;
	private float tableY;
	private float pieceX;
	private float pieceY;
	private D d;

	public Exercise_4() {
	}

	public Exercise_4(String s) {
		super(s);
	}

	@Override
	protected void setUp() {
		System.out.println("per-method start...");
		d = new D();
		tableX = d.getTableSize().getTableX();
		tableY = d.getTableSize().getTableY();
		pieceX = d.getWorkpieceSize().getPieceX();
		pieceY = d.getWorkpieceSize().getPieceY();
	}

	@Override
	protected void tearDown() {
		System.out.println("per-method end!");
	}

	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(Exercise_4.class);

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

	public void testMoveTo() {
		float x = -1.0f;
		float y = 0.0f;
		try {
			d.moveTo(x, y);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			x = 0.0f;
			y = -1.0f;
			d.moveTo(x, y);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			x = -1.0f;
			y = -1.0f;
			d.moveTo(x, y);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.moveTo(tableX, 1.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.moveTo(1.0f, tableY);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.moveTo(tableX, tableY);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		d.moveTo(0.0f, 0.0f);
		d.moveTo(tableX - 1, tableY - 1);
		assertTrue(true);
	}

	public void testSewTo() {
		float x = -1.0f;
		float y = 0.0f;
		try {
			d.sewTo(x, y);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			x = 0.0f;
			y = -1.0f;
			d.sewTo(x, y);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			x = -1.0f;
			y = -1.0f;
			d.sewTo(x, y);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.sewTo(pieceX, 1.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.sewTo(1.0f, pieceY);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.sewTo(pieceX, pieceY);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		d.sewTo(0.0f, 0.0f);
		d.sewTo(pieceX -1, pieceY -1);
	}
	
	public void testSetWorkpieceSize() {
		try {
			d.setWorkpieceSize(-1.0f, 1.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.setWorkpieceSize(1.0f, -1.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.setWorkpieceSize(-1.0f, -1.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.setWorkpieceSize(tableX +1, 1.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.setWorkpieceSize(1.0f, tableY + 1);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.setWorkpieceSize(tableX +1, tableY + 1);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		try {
			d.setWorkpieceSize(0.0f, 0.0f);
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
		d.setWorkpieceSize(0.0f, 0.0f);
		d.setWorkpieceSize(tableX, tableY);
		assertTrue(true);
	}
	
	public void testGetWorkpieceSize() {
		Size pieceSize = d.getWorkpieceSize();
		Size tableSize = d.getTableSize();
		assertTrue(pieceSize != null);
		assertTrue(tableSize != null);
		assertTrue(pieceSize.getPieceX() > 0.0f);
		assertTrue(pieceSize.getPieceY() > 0.0f);
		assertTrue(pieceSize.getPieceX() <= tableSize.getTableX() - 1);
		assertTrue(pieceSize.getPieceY() <= tableSize.getTableY() - 1);
	}
	
	public void testGetTableSize() {
		Size pieceSize = d.getWorkpieceSize();
		Size tableSize = d.getTableSize();
		assertTrue(pieceSize != null);
		assertTrue(tableSize != null);
		assertTrue(tableSize.getTableX() > 0);
		assertTrue(tableSize.getTableY() > 0);
		assertTrue(tableSize.getTableX() - 1 >= pieceSize.getPieceX());
		assertTrue(tableSize.getTableY() - 1 >= pieceSize.getPieceY());
	}
}

interface C {
	void moveTo(float x, float y);

	void sewTo(float x, float y);

	void setWorkpieceSize(float width, float height);

	Size getWorkpieceSize();

	Size getTableSize();
}

class Size {
	float tableX;
	float tableY;
	float pieceX;
	float pieceY;

	public float getTableX() {
		return tableX;
	}

	public void setTableX(float tableX) {
		this.tableX = tableX;
	}

	public float getTableY() {
		return tableY;
	}

	public void setTableY(float tableY) {
		this.tableY = tableY;
	}

	public float getPieceX() {
		return pieceX;
	}

	public void setPieceX(float pieceX) {
		this.pieceX = pieceX;
	}

	public float getPieceY() {
		return pieceY;
	}

	public void setPieceY(float pieceY) {
		this.pieceY = pieceY;
	}

}

class D implements C {

	@Override
	public void moveTo(float x, float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sewTo(float x, float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setWorkpieceSize(float width, float height) {
		// TODO Auto-generated method stub

	}

	@Override
	public Size getWorkpieceSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Size getTableSize() {
		// TODO Auto-generated method stub
		return null;
	}
}