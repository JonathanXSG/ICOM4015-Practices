package doublyLinkedList;

public interface XLinkedList <E> {

	int size();
	boolean isEmpty();
	
	void addFirst(E e); 
	void addLast(E e); 
	void addAtPosition(int i, E e)throws Exception;
	
	XNode<E> removeFirst(); 
	XNode<E> removeLast(); 
	
	void replaceFirstByVal(E oldVal, E newVal)throws Exception;
	void replaceLastByVal(E oldVal, E newVal)throws Exception;
	void replaceAllByVal(E oldVal, E newVal)throws Exception;
	XNode<E> replaceAtIndex(int i, E e)throws Exception; 
	
	E get(int i)throws Exception;
	XNode<E> getNode(int i)throws Exception;
	
	
	
}
