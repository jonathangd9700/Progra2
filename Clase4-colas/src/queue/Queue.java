package queue;

public interface Queue<T> {
	public void enqueue(T e);
	
	public T dequeue();
	
	
}
