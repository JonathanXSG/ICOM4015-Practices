package doublyLinkedList;

public class XDoublyLinkedList <E> implements XLinkedList<E>{

	private XNode<E> head, tail; 
	private int length; 
	
	public XDoublyLinkedList(){
		this.length = 0;
		this.head = new XNode<E>();
		this.tail = new XNode<E>();
		this.head.setNext(tail);
		this.tail.setPrev(head);
	}

	@Override
	public int size() {
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		return this.length==0;
	}

	@Override
	public void addFirst(E e) {
		XNode<E> tempNode = new XNode<E>(e, this.head,this.head.getNext());
		this.head.setNext(tempNode);
		tempNode.getNext().setPrev(tempNode);
		length++;
	}

	@Override
	public void addLast(E e) {
		XNode<E> tempNode = new XNode<E>(e, this.tail.getPrev(),this.tail);
		this.tail.setPrev(tempNode);
		tempNode.getPrev().setNext(tempNode);
		length++;
	}

	@Override
	public void addAtPosition(int i, E e) throws Exception {
		XNode<E> oldNode;
		oldNode = findNodeAtIndex(i);
		
		XNode<E> tempNode = new XNode<E>(e, oldNode.getPrev(),oldNode);
		oldNode.getPrev().setNext(tempNode);
		oldNode.setPrev(tempNode);

		length++;
	}

	@Override
	public XNode<E> removeFirst() {
		XNode<E> tempNode = this.head.getNext();
		this.head.setNext(tempNode.getNext());
		this.head.getNext().setPrev(head);
		length--;
		return tempNode;
	}

	@Override
	public XNode<E> removeLast() {
		XNode<E> tempNode = this.tail.getPrev();
		this.tail.setPrev(tempNode.getPrev());
		this.tail.getPrev().setPrev(head);
		length--;
		return tempNode;
	}

	@Override
	public void replaceFirstByVal(E oldVal, E newVal) throws Exception {
		XNode<E> tempNode= this.head.getNext();
		int counter = 0;
		
		for(int i=0 ; i<this.length ; i++){
			if(tempNode.getElement().equals(oldVal)){
				tempNode.setElement(newVal);
				counter++;
				break;
			}
			tempNode = tempNode.getNext();
		}
		if(counter==0) throw new Exception("Value not found in list.");
	}

	@Override
	public void  replaceLastByVal(E oldVal, E newVal) throws Exception {
		XNode<E> tempNode= this.tail.getPrev();
		int counter = 0;
		
		for(int i=0 ; i<this.length ; i++){
			if(tempNode.getElement().equals(oldVal)){
				tempNode.setElement(newVal);
				counter++;
				break;
			}
			tempNode = tempNode.getPrev();
		}
		if(counter==0) throw new Exception("Value not found in list.");
	}

	@Override
	public void  replaceAllByVal(E oldVal, E newVal) throws Exception {
		XNode<E> tempNode= this.head.getNext();
		int counter = 0;
		
		for(int i=0 ; i<this.length ; i++){
			if(tempNode.getElement().equals(oldVal)){
				tempNode.setElement(newVal);
				counter++;
			}
			tempNode = tempNode.getNext();
		}
		if(counter==0) throw new Exception("Value not found in list.");
	}

	@Override
	public XNode<E> replaceAtIndex(int i, E e) throws Exception {
		XNode<E> tempNode = findNodeAtIndex(i);
		findNodeAtIndex(i).setElement(e);
		return tempNode;
	}

	@Override
	public E get(int i) throws Exception {
		return findNodeAtIndex(i).getElement();
	}
	
	private XNode<E> findNodeAtIndex(int index) throws Exception{
		XNode<E> tempNode= this.head;
		
		if(index > this.length || index<0) throw new Exception("Index is out of Bounds");
		else{
			for(int i=0 ; i<=index ; i++){
				tempNode = tempNode.getNext();
			}
		}
		return tempNode;
	}

	@Override
	public XNode<E> getNode(int i) throws Exception {
		return findNodeAtIndex(i);
	}


}