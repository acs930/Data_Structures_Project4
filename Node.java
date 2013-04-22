
public class Node <T>{
  
	private T element;
	private Node<T> next;
	
	public Node()
	{
		this(null, null);
	}
	
	public Node(T theElement, Node<T> theNode)
	{
		element = theElement;
		next = theNode;
		
	}
	
	public T getElement()
	{
		return element;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public void setElement(T newElement)
	{
		element = newElement;
	}
	
	public void setNext(Node<T> theNext)
	{
		next = theNext;
	}
	

}
