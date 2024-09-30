package ejercicio4;

public interface Queue<T> {
	public void enqueue(T e);
	public T dequeue();
	public T front();
	public boolean isEmpty();
	public int size();
}
