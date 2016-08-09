package com.asiainfo;

import junit.framework.TestCase;

/**
 * 对期望抛出的异常进行测试
 *
 * @author zhiwangzhang
 * @date 2016年8月9日 上午8:35:03
 */
public class Test15 extends B {
	private void queryById(long id) {
		String s = null;
		s.length();
		if (id <= 0) {
			throw new RuntimeException("id should > 0");
		}
	}

	public void testQueryById() {
		try {
			queryById(-1);
			fail("should throw an exception");
		} catch (Exception e) {
			assertNotNull("not willing exception", e.getMessage());
			assertEquals("ohterException", "id", e.getMessage().substring(0, 2));
		}
	}
}
