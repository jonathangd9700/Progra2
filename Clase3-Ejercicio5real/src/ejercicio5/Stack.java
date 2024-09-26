package ejercicio5;

public interface Stack<T> {
	public void push(T item);
	public T pop();
	public T top();
	public boolean isEmpty();
	public int size();
}
