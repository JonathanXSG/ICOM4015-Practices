package sLLBasedStack;


public class SLLBasedStack <E> implements Stack<E>{

	private int topPointer;
	private SNode<E> head; 
	
	public SLLBasedStack() {
		this.head = null;
		this.topPointer = -1;
	}
	
	public SLLBasedStack(E element) {
		this.head = new SNode<>(element);
		this.topPointer =0;
	}
	
	@Override
	public void push(E element) {
		SNode<E> newNode = new SNode<>(element,head);
		head = newNode; 
		topPointer++;
	}

	@Override
	public void pop() {
		if(!isEmpty()) {
			head = head.getNext(); 
			topPointer--; 
		}
	}

	@Override
	public E peek() {
		return head.getElement();
	}

	@Override
	public int size() {
		return topPointer+1;
	}

	@Override
	public boolean isEmpty() {
		return topPointer==-1;
	}

	@Override
	public E[] getElements() {
		if(!isEmpty()) {
			@SuppressWarnings("unchecked")
			E[] elements = (E[]) new Object[topPointer+1];
			SNode<E> tempNode = head;
			for(int i=0;i<=topPointer;i++) {
				elements[i] = tempNode.getElement();
				tempNode= tempNode.getNext();
			}
			return elements;
		}
		else {
			return null;
		}
	}

}
