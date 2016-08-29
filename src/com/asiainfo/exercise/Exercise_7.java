package com.asiainfo.exercise;

import java.util.ArrayList;
import java.util.List;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Exercise_7.java
 * @Description: p76练习7
 * 
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年8月29日 下午4:26:37
 * 
 *        Modification History: Date Author Version Description ---------------------------------------------------------* 2016年8月29日 zhangzw8 v1.0.0 创建
 */
public class Exercise_7 extends TestCase {
	private Mp3 mp3;
	private List<String> list = new ArrayList<String>();

	public Exercise_7() {
	}

	public Exercise_7(String s) {
		super(s);
	}

	@Override
	protected void setUp() {
		mp3 = new MockMp3();
		list.add("a");
		list.add("b");
		list.add("c");
	}

	@Override
	protected void tearDown() {
		System.out.println("per-method end!");
	}

	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(Exercise_7.class);

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

	public void testPlay() {
		mp3.load(list);
		assertFalse(mp3.isPlaying());
		mp3.play();
		assertTrue(mp3.isPlaying());
		assertTrue(mp3.currentPosition() != 0.0);
		mp3.pause();
		assertTrue(mp3.currentPosition() != 0.0);
		mp3.stop();
		assertTrue(mp3.currentPosition() == 0.0);
	}

	public void testPlayNoList() {
		assertFalse(mp3.isPlaying());
		mp3.play();
		assertFalse(mp3.isPlaying());
		assertEquals(0.0, mp3.currentPosition(), 0.1);
		mp3.pause();
		assertFalse(mp3.isPlaying());
		assertEquals(0.0, mp3.currentPosition(), 0.1);
		mp3.stop();
		assertFalse(mp3.isPlaying());
		assertEquals(0.0, mp3.currentPosition(), 0.1);
	}

	public void testAdvance() {
		mp3.load(list);
		mp3.play();
		assertTrue(mp3.isPlaying());
		mp3.prev();
		assertEquals(list.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		mp3.next();
		assertEquals(list.get(1), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(2), mp3.currentSong());
		mp3.prev();
		assertEquals(list.get(1), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(2), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(3), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(3), mp3.currentSong());
		assertTrue(mp3.isPlaying());
	}
}

interface Mp3 {
	void play();

	void pause();

	void stop();

	double currentPosition();

	String currentSong();

	void next();

	void prev();

	boolean isPlaying();

	void load(List<String> list);
}

class MockMp3 implements Mp3 {
	private boolean isPlaying;
	private double currPos;
	private List<String> list = new ArrayList<String>();
	private int index;
	
	@Override
	public void play() {
		if(list.size() > 0) {
			isPlaying = true;
			currPos = 0.1;
		}
	}

	@Override
	public void pause() {
		isPlaying = false;
	}

	@Override
	public void stop() {
		if(list.size() == 0 || !isPlaying) {
			return;
		}
		isPlaying = false;
		currPos = 0.0;
	}

	@Override
	public double currentPosition() {
		return currPos;
	}

	@Override
	public String currentSong() {
		if(list.size() == 0) {
			return null;
		}
		return list.get(index);
	}

	@Override
	public void next() {
		if(list.size() == 0 || index == list.size() - 1) {
			currPos = 0.0;
			return;
		}
		index++;
		currPos = 0.0;
	}

	@Override
	public void prev() {
		if(list.size() == 0 || index == 0) {
			currPos = 0.0;
			return;
		}
		index--;
		currPos = 0.0;
	}

	@Override
	public boolean isPlaying() {
		return isPlaying;
	}

	@Override
	public void load(List<String> list) {
		this.list.addAll(list);
	}
}