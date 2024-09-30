package DinamicQueue;

public class LinkedQueue<T> implements Queue<T> {
	private Node<T> front;
	private Node<T> tail;
	private int size;
	
	public LinkedQueue() {
		front = null;
		tail = null;
		size = 0;
	}
	
	public void enqueue(T e) {
		Node<T> aux = new Node<T>(e,null);
		if(size == 0) {
			front = aux;
			tail = aux;

		}
		else {
			tail.setNext(aux);
			tail = aux;
		}
		size++;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			System.out.println("La cola está vacia. No puede eliminar elementos");
			return null;
		}
		else {
			T elemento = front.getElement();
			front = front.getNext();
			size--;
			if(size == 0) {
				tail =null;
			}
			return elemento;
		}

	}
	
	public T front() {
		if(isEmpty()) {
			System.out.println("La cola está vacia");
			return null;
		}
		else {		
			return front.getElement();
		}
		

	}
	
	public boolean isEmpty() {
		return size ==0;
	}
	
	public int size() {
		return size;
	}
}
