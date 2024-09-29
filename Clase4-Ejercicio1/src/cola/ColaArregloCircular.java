package cola;

public class ColaArregloCircular<T> implements Queue<T>{
	
	private T[] array;
	private int front;
	private int tail;
	private int size;
	
	public ColaArregloCircular() {
		array = (T[]) new Object[10];
		front = 0;
		tail = 0;
		size = 0;
	};
	
	public ColaArregloCircular(int cantidadElementos) {
		try {
		array = (T[]) new Object[cantidadElementos];
		front = 0;
		tail = 0;
		size = 0;
		}
		catch(NegativeArraySizeException e) {
			System.out.println("La longitud de la pila no puede ser negativa");
		}
	}
	
	public void enqueue (T e) {
		if(size == array.length) {
			System.out.println("La cola está llena");
		}
		else {
			array[tail] = e;
			tail = (tail+1)%array.length;
			size++;
		};
	};
	
	public T dequeue () {
		if(size == 0) {
			System.out.println("No hay elementos para desencolar");
			return null;
		}
		else {
			T aux = array[front];
			array[front] = null;
			front= (front+1)%array.length;
			size --;
			return aux;
		}
		
	};
	
	public T front() {
		if (size == 0) {
				System.out.println("La cola está vacia");
		return null;
		}
		
		return array[front];

	};
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;

	};
	
	public int size() {
		return size;
	};
	
}
