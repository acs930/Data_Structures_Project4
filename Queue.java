
public interface Queue <T>{
  
	public int size();
	
	public boolean isEmpty();
	
	public T front();
	
	public void enqueue(T element);
	
	public T dequeue();
		

}
