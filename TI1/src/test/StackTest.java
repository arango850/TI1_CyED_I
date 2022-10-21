package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structures.Stack;

class StackTest {

	@Test
	public void stackTest() {
		Stack stack = new Stack(2);
		
		assertEquals(2, stack.size());
		
	}
	
	@Test
	public void stackTest2() {
		Stack stack = new Stack(10);
		
		assertEquals(10, stack.size());
		
	}
	@Test
	public void stackTest3() {
		Stack stack = new Stack(14);
		
		
		assertEquals(14, stack.size());
	}
	
	@Test
	public void pushTest() {
		Stack stack = new Stack(14);
		int a = 1;
		int b = 2;
		
		stack.push(a);
		stack.push(b);
		
		assertEquals(2, stack.peek());
	}
	
	@Test
	public void pushTest2() {
		Stack stack = new Stack(14);
		int a = 1;
		int b = 2;
		int c = 10;
		int f = 14;
		
		stack.push(a);
		stack.push(b);
		stack.push(c);
		stack.push(f);
		assertEquals(14, stack.peek());
	}
	@Test
	public void popTest2() {
		Stack stack = new Stack(14);
		int a = 1;
		int b = 2;
		int c = 10;
		int f = 14;
		
		stack.push(a);
		stack.push(b);
		stack.push(c);
		stack.push(f);
		stack.pop();
		assertEquals(10, stack.peek());
	}
	
	@Test 
	public void popTest3() {
		Stack stack = new Stack(3);
		String a = "Hola";
		String b  = "Mundo";
		String c = "World";
		stack.push(a);
		stack.push(b);
		stack.push(c);
		stack.pop();
		stack.pop();
		assertEquals("Hola",stack.peek());
		
	}

}
