package com.asiainfo;

import org.junit.Assert;
import org.junit.Test;

/**   
 * Copyright: Copyright (c) 2016 Asiainfo
 * 
 * @ClassName: Test16.java
 * @Description: Assert.assertEquals()
 *
 * @version: v1.0.0
 * @author: zhangzw8
 * @date: 2016年8月31日 下午8:03:33
 *
 * Modification History:
 * Date             Author          Version            Description
 *---------------------------------------------------------*
 * 2016年8月31日     zhangzw8           v1.0.0               创建
*/
public class Test16 {
	@Test
	public void test() {
		Assert.assertEquals(1.1, 1.2, 0.1);//why?
		Assert.assertEquals(1.1, 1.2, 0.01);//why?
	}
}
