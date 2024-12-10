package parcial;

public interface Stack<E> {
	public void push(E item);
	public E pop();
	public E top();
	public boolean isEmpty();
	public int size();
}
