package structures;

import exceptions.isEmptyExceptionStack;
import exceptions.isFullExceptionStack;
import interfacee.IStack;

public class Stack<T> implements IStack<T> {

	private int current;
	private int size;
	private T stack[];
	
	public Stack(int size) {
		this.size= size;
		current =0;
		stack= (T[]) new Object[this.size];
	}
	
	@Override
	public void push(T obj) {
		// TODO Auto-generated method stub
		if(current>size) {
			throw new isFullExceptionStack();
		}else {
			stack[current++]= obj;
		}
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(current ==0) {
			throw new isEmptyExceptionStack();
			
		}else {
			return stack[-- current];
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(current==0) {
			throw new isEmptyExceptionStack();
			
		}else {
			int aux = current;
			return stack[--aux];
		}
	}
	
	public int size() {
		return size;
	}

	
	
}
