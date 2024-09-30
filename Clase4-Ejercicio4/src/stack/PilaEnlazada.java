package stack;

import ejercicio4.Node;
 

public class PilaEnlazada<T> implements Stack<T> {
	private Node<T> top;
	private int size;
	
	public PilaEnlazada() {
		top = null;
		size = 0;
	}
	
	public void push(T item) {
		Node<T> nuevoNodo = new Node<T>(item,top);
		top = nuevoNodo;
		size++;
	}
	
	public T pop() {
		if(size == 0) {
			System.out.println("La pila está vacia");
			return null;
		}
		else {
			Node<T> antiguoTop = top;
			top = antiguoTop.getNext();
			antiguoTop.setNext(null);
			size--;
			return antiguoTop.getElement();	
		}
	}
	
	public T top() {
		if(size == 0) {
			System.out.println("La pila está vacia");
			return null;
		}
		return top.getElement();
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return size;
	}
}

