
public class theLinkedQueue <T> implements Queue <T>{

  private Node <T> head, tail;
	int size;
	
	public theLinkedQueue()
	{
		size = 0;
		head = null;
		tail = null;
	}
	
	public int size() {
		
		return size;
	}

	
	public boolean isEmpty() {
		if((head == null) && ( tail == null))
		{
			return true;
		}
		
		return false;
	}

	
	public T front() {
		
		T front = null;
		if(!isEmpty())
		{
			front = head.getElement();
		}
		return front;
	}

    public void clear ()
    {
        head = null;
        tail = null;
    } 
	
	public void enqueue( T element) {
		
		Node<T> node = new Node<T>();
		node.setElement(element);
		node.setNext(null);
		
		if(size == 0)
		{
			head = node;
		}
		else
		{
			tail.setNext(node);
		}
		
		tail = node;
		size++;
	}

	
	public T dequeue() {
		
		T tempNode = head.getElement();
		
		head = head.getNext();
		size --;
		if(size == 0)
		{
			tail = null;
		}
		return tempNode;

	}
	
	/*public String toString()
	{
		String theString = "|";
		int tempSize = size;
		
		Node<T> tempNode = head;
		tempNode.setNext(head.getNext());
		T nodeElement;// = head.getElement();
		
		while ( tempSize > 0)
		{
			theString += " ";
			nodeElement = tempNode.getElement();
			theString += nodeElement;
			
			tempNode.setElement(tempNode.getNext().getElement());
			tempNode.setNext(tempNode.getNext());
			
			tempSize--;
		}
		
		theString += " |";
		return theString;
		
	}*/
	
	
	  public static void main(String args[]) {
		    theLinkedQueue<Integer> iQueue = new theLinkedQueue<Integer>();
		    iQueue.enqueue(1);
		    iQueue.enqueue(2);
		    iQueue.enqueue(13);
		    System.out.println(iQueue.dequeue());
		    System.out.println(iQueue.dequeue());
		    System.out.println(iQueue.dequeue());

		    
		    
		    
		  }
	

}
