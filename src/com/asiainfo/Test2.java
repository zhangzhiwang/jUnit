package com.asiainfo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试
 *
 * @author zhiwangzhang
 * @date 2016年8月5日 下午9:53:14
 */
public class Test2 {
	public static int largest(int[] is) {
		int max = Integer.MIN_VALUE;
		if (is == null) {
			return max;
		}
		for (int i = 0; i < is.length; i++) {
			if (is[i] > max) {
				max = is[i];
			}
		}
		return max;
	}

	@Test
	public void test1() {
		Assert.assertEquals(9, largest(new int[] { 7, 8, 9 }));
		Assert.assertEquals(9, largest(new int[] { 7, 9, 8 }));
		Assert.assertEquals(9, largest(new int[] { 9, 8, 7 }));
		Assert.assertEquals(9, largest(new int[] { 7, 9, 9 }));
		Assert.assertEquals(9, largest(new int[] { 9, 8, 9 }));
		Assert.assertEquals(9, largest(new int[] { 9 }));
		Assert.assertEquals(-1, largest(new int[] { -1, -2, -3 }));
		Assert.assertEquals(-1, largest(new int[] { -1, -1, -3 }));
		Assert.assertEquals(-1, largest(new int[] { -1, -1, -1 }));
		Assert.assertEquals(0, largest(new int[] { -1, -2, 0 }));
		Assert.assertEquals(1, largest(new int[] { -1, 0, 1 }));
		Assert.assertEquals(Integer.MIN_VALUE, largest(new int[] {}));
		Assert.assertEquals(Integer.MIN_VALUE, largest(null));
	}
}
