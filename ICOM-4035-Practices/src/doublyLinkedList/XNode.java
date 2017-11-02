package doublyLinkedList;

public class XNode <E> {
	
	private E element;
	private XNode<E> prev;
	private XNode<E> next;
	
	public XNode() {
		this.element = null; 
		this.next = null;
		this.prev = null;
	}

	public XNode(E e) { 
		this.element = e; 
		this.next = null;
		this.prev = null;
	}
	
	public XNode(E e, XNode<E> p, XNode<E> n) { 
		this.element = e; 
		this.prev = p; 
		this.next = n; 
	}
	
	public XNode<E> getPrev() {
		return prev;
	}
	public void setPrev(XNode<E> prev) {
		this.prev = prev;
	}
	public XNode<E> getNext() {
		return next;
	}
	public void setNext(XNode<E> next) {
		this.next = next;
	}
	public E getElement() {
		return this.element; 
	}
	public void setElement(E data) {
		element = data; 
	} 
	
	@Override
	public String toString() {
		return "XNode [element=" + element +"]";
	}
	
}
