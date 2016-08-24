package com.asiainfo.exercise;

import junit.framework.TestCase;

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
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016年8月24日     zhangzw8           v1.0.0               创建
*/
public class Exercise_4 extends TestCase {
	public Exercise_4() {}
	
	public Exercise_4(String s) {
		super(s);
	}
	
	@Override
	protected void setUp() {
		System.out.println("per-method start...");
	}
	
	@Override
	protected void tearDown() {
		System.out.println("per-method end!");
	}
	
//	public static 
}

interface C {
	void moveTo(float x, float y);
	void setTo(float x, float y);
	void setWorkpieceSize(float width, float height);
	Size getWorkpieceSize();
	Size getTableSize();
}

class Size {}

class D implements C {

	@Override
	public void moveTo(float x, float y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTo(float x, float y) {
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
	}}