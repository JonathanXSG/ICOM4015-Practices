package sLLBasedStack;

public interface Stack<E> {

	void push(E element);
	void pop();
	E peek();
	
	int size();
	boolean isEmpty();
	E[] getElements();
	
}
