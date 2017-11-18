package sLLBasedStack;

public class SNode<T> implements Node<T> {
	private T element; 
	private SNode<T> next; 
	public SNode() { 
		element = null; 
		next = null; 
	}
	public SNode(T data, SNode<T> next) { 
		this.element = data; 
		this.next = next; 
	}
	public SNode(T data)  { 
		this.element = data; 
		next = null; 
	}
	public T getElement() {
		return element;
	}
	public void setElement(T data) {
		this.element = data;
	}
	public SNode<T> getNext() {
		return next;
	}
	public void setNext(SNode<T> next) {
		this.next = next;
	}
}
