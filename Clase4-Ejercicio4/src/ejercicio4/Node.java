package ejercicio4;

public class Node<T> {
	private T info;
	private Node sig;
	
	public Node(T elemento, Node sigNodo) {
		info = elemento;
		sig = sigNodo;
	}
	
	public T getElement() {
		return info;
	}
	
	public Node getNext() {
		return sig;
	}
	
	public void setElement(T elemento) {
		info = elemento;
	}
	
	public void setNext(Node n) {
		sig = n;
	}
}
