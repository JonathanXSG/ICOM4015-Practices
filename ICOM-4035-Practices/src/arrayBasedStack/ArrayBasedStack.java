
package arrayBasedStack;

public class ArrayBasedStack<E> implements Stack<E> {

	private int topPointer;
	private E[] elements;
	
	@SuppressWarnings("unchecked")
	public ArrayBasedStack() {
		this.topPointer = -1;
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
		topPointer++;
		elements[topPointer] = element;
	}

	@Override
	public void pop() {
		if(!isEmpty()) {
			elements[topPointer] = null;
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
		if (!isEmpty()) {
			return elements[topPointer];
		}
		else {
			return null;
		}
	}

	@Override
	public int size() {
		return topPointer+1;
	}

	@Override
	public boolean isEmpty() {
		return  topPointer==-1;
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
