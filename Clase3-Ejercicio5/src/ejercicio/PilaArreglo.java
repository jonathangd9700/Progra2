package ejercicio;

public class PilaArreglo<T> implements Stack<T> {
	private T[] array;
	private int size;
	
	public PilaArreglo() {
		array = (T[]) new Object[10];
		size = 0;
	}
	public PilaArreglo(int cantElementos) {
		try {
			array = (T[]) new Object[cantElementos];
			size = 0;
		}
		catch(NegativeArraySizeException e) {
			System.out.println("La longitud de la pila no puede ser negativa");
		}

	}
	public void push(T item) {
		try {
			array[size] = item;
			size++;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No puede agregar más elementos. Pila llena.");
		}
	};
	
	public T pop() {
		T aux;
	if(size >0) {
		aux = array[size-1];
		size--;
		return aux;
	}
	System.out.println("No puede eliminar elementos con la pila vacia.");
	return null;
	};
	
	public T top() {
		if(size == 0) {
			System.out.println("La pila está vacia.");
			return null;
		}
		return array[size-1];
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
	
	public void imprimirElementos() {
		if(size>0) {
		for(int i = 0; i< size;i++) {
			System.out.println(array[i]);
		}
	}

	else {
		System.out.println("La pila está vacia");
	}
	}	
	
	
	/*public void invertir(PilaArreglo pila) {
		T[] array2;
		array2 = (T[]) new Object[size];
		int posicion = 0;	
		for(int i = size-1; i>0;i--) {
			array2[posicion] = (T) pila.array[i];
			posicion++;
		}
		pila.array = array2;
		}
*/
	public void invertir(PilaArreglo pila) {
		T[] array2;
		array2 = (T[]) new Object[size];
		int posicion = 0;
		while(size>0) {
			T el = (T) pila.pop();
			array2[posicion] = (T) el;
			posicion++;
		}
	    for (int i = 0; i < posicion; i++) {
	        pila.push(array2[i]);
	    }
	}
		
	}

