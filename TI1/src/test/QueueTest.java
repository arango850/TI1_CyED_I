package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structures.Queue;

class QueueTest {

Queue queue = new Queue(10);
	
	@Test
	public void addTest() {
		String a = "Hola";
		queue.add(a);
		
		assertEquals(1, queue.size());
	}
	
	@Test
	public void addTest2() {
		
		int a = 1;
		int b = 2;
		
		queue.add(a);
		queue.add(b);
		
		assertEquals(2, queue.size());
		
	}
	
	@Test
	public void addTest3() {
		int a = 1;
		String b = "Hola";
		
		queue.add(a);
		queue.add(b);
		
		assertEquals(2, queue.size());
		
	}
	@Test
	public void peekTest() {
		int a = 1;
		int b = 2;
		int c = 3;
		queue.add(a);
		queue.add(b);
		queue.add(c);
		
		assertEquals(1,queue.peek());
		
	}
	
	@Test
	public void peekTest2() {
		int a = 10;
		queue.add(a);
		
		assertEquals(10,queue.peek());
		
	}
	
	@Test
	public void peekTest3() {
		String a = "Hola";
		String b = "Mundo";
		queue.add(a);
		queue.add(b);
		
		assertEquals("Hola",queue.peek());
		
	}
	
	@Test
	public void poolTest() {
		String a = "Hola";
		String b = "Mundo";
		queue.add(a);
		queue.add(b);
		queue.pool();
		assertEquals("Mundo",queue.peek());
		
	}
	
	@Test
	public void poolTest1() {
		int a = 1;
		int b = 2;
		queue.add(a);
		queue.add(b);
		queue.pool();
		assertEquals(2,queue.peek());
		
	}
}
