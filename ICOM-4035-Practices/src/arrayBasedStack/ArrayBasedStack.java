
package arrayBasedStack;

import java.util.Arrays;

public class ArrayBasedStack<E> implements Stack<E> {

	private int topPointer;
	private E[] elements;
	
	@SuppressWarnings("unchecked")
	public ArrayBasedStack() {
		this.topPointer = 0;
		this.elements = (E[])new Object[10];
	}
	
	public ArrayBasedStack(E[] elements) {
		this.elements = elements;
		this.topPointer =elements.length;
	}

	@Override
	public void push(E element) {
		if(topPointer >= elements.length/2 + elements.length/4) {
			E[] newArray = (E[])new Object[ elements.length*2];
			for (int i = 0; i < elements.length; i++) {
				newArray[i] = elements[i];
			}
			elements =newArray;
		}
		elements[topPointer] = element;
		topPointer++;
	}

	@Override
	public void pop() {
		if(topPointer!=0) {
			topPointer--;
			if(topPointer < elements.length/2 - elements.length/4) {
				E[] newArray = (E[])new Object[ elements.length/2];
				for (int i = 0; i < newArray.length; i++) {
					newArray[i] = elements[i];
				}
				elements =newArray;
			}
		}
	}

	@Override
	public E peek() {
		if (topPointer>0) {
			return elements[topPointer-1];
		}
		else {
			return null;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return topPointer;
	}

	@Override
	public boolean isEmpty() {
		return  topPointer==0;
	}
	
	@Override
	public E[] getElements() {
		return  elements;
	}

	public void setElements(E[] elements) {
		this.elements = elements;
		this.topPointer =elements.length;
	}

}
