package com.asiainfo.exercise;

import junit.framework.TestCase;

/**
 * p61练习2
 *
 * @author zhiwangzhang
 * @date 2016年8月10日 下午9:32:03
 */
public class Exercise_2 extends TestCase {
	private ShoppingCartImpl shoppingCartImpl;

	@Override
	protected void setUp() {
		shoppingCartImpl = new ShoppingCartImpl();
	}

	public void testAddItems() {
		try {
			shoppingCartImpl.addItems(null, 1);
			fail("该抛异常而未抛异常");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}

		try {
			shoppingCartImpl.addItems(new Item(), 0);
			fail("该抛异常而未抛异常");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}

		try {
			shoppingCartImpl.addItems(new Item(), -1);
			fail("该抛异常而未抛异常");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
		try {
			shoppingCartImpl.addItems(new Item(), 5);
			shoppingCartImpl.addItems(new Item(), 1);
			fail("该抛异常而未抛异常");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
		
		shoppingCartImpl = new ShoppingCartImpl();
		assertEquals("err", 0, shoppingCartImpl.itemCount());
		shoppingCartImpl.addItems(new Item(), 1);
		assertEquals("err", 1, shoppingCartImpl.itemCount());
	}
	
	public void testDeleteItems() {
		try{
			shoppingCartImpl.deleteItems(new Item(), 1);
			fail("该抛异常而未抛异常");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue(e instanceof NegativeCountException);
		}
		
		try{
			shoppingCartImpl.deleteItems(null, 1);
			fail("该抛异常而未抛异常");
		}catch(Exception e) {
			assertTrue(true);
		}
		
		try{
			shoppingCartImpl.deleteItems(new Item(), 0);
			fail("该抛异常而未抛异常");
		}catch(Exception e) {
			assertTrue(true);
		}
		
		try{
			shoppingCartImpl.deleteItems(new Item(), -1);
			fail("该抛异常而未抛异常");
		}catch(Exception e) {
			assertTrue(true);
		}
		
		try {
		shoppingCartImpl.addItems(new Item(), 1);
		shoppingCartImpl.deleteItems(new Item(), 1);
		fail("该抛异常而未抛异常");
		}catch(Exception e) {
			assertTrue(e instanceof NoSuchItemException);
		}
		assertEquals("err", 1, shoppingCartImpl.itemCount());
		
		try {
		shoppingCartImpl = new ShoppingCartImpl();
		Item item = new Item();
		shoppingCartImpl.addItems(item, 3);
		shoppingCartImpl.deleteItems(item, 4);
		}catch(Exception e) {
			assertTrue(e instanceof NegativeCountException);
		}
		
		try{
			shoppingCartImpl = new ShoppingCartImpl();
			Item item = new Item();
			shoppingCartImpl.addItems(item, 1);
			shoppingCartImpl.addItems(item, 1);
			assertEquals("err", 2, shoppingCartImpl.itemCount());
			shoppingCartImpl.deleteItems(item, 1);
			shoppingCartImpl.deleteItems(item, 1);
			assertEquals(0, shoppingCartImpl.itemCount());
			shoppingCartImpl.deleteItems(item, 1);
			fail("该抛异常而未抛异常");
		}catch(Exception e) {
			assertTrue(e instanceof NegativeCountException);
		}
		
	}
	
	public void testItemCount() {
		assertEquals("err", 0, shoppingCartImpl.itemCount());
		Item item = new Item();
		shoppingCartImpl.addItems(item, 3);
		shoppingCartImpl.deleteItems(item, 1);
		assertEquals("err", 2, shoppingCartImpl.itemCount());
	}
}

interface ShoppingCart {
	// 业务要求购物车容量是5
	void addItems(Item item, int quantity) throws NegativeCountException;

	void deleteItems(Item item, int quantity) throws NegativeCountException, NoSuchItemException;

	int itemCount();
}

class ShoppingCartImpl implements ShoppingCart {

	@Override
	public void addItems(Item item, int quantity) throws NegativeCountException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteItems(Item item, int quantity) throws NegativeCountException, NoSuchItemException {
		// TODO Auto-generated method stub

	}

	@Override
	public int itemCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Item {
}

class NegativeCountException extends RuntimeException {
}

class NoSuchItemException extends RuntimeException {
}