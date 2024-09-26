package capicua;

public class PilaEnlazada<T> implements Stack<T>{
	private Node<T> top;
	private int size;
	public PilaEnlazada() {
		top = null;
		size = 0;
	}
	
	public void push(T element) {
		Node <T> nuevoNodo = new Node<T>(element,top);
		top = nuevoNodo;
		size++;
	}

	public T pop() {
		if(size == 0) {
			System.out.println("La pila está vacia");
			return null;
		}
			Node<T> viejoTop = top; //el top actual lo asigno al nodo viejoTop
			top = viejoTop.getNext(); //ahora el top actual es igual nodo anterior a top, ya que viejoTop.getNext() apunta al nodoActual-1
			viejoTop.setNext(null); //al top anterior le asigno setNext = null para que pierda referencia con la pila
			size--;
			return viejoTop.getElement();
		}
	
	public T top() {
		if(size == 0) {
			System.out.println("La pila está vacia");
			return null;
		}
		return top.getElement();
	}
	
	public boolean isEmpty() {
		boolean empty = false;
		if(size == 0) {
			return empty = true;
		}
		return empty;
	}
	
	public int size() {
		return size;
	}
	
	}
