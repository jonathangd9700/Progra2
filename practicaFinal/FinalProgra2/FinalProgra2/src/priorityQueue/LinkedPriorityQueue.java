package priorityQueue;

import queue.NodoCola;

public class LinkedPriorityQueue<K extends Comparable<K>,V> implements PriorityQueue<K,V>{

	protected NodoCola<Entrada<K,V>> head;
	protected NodoCola<Entrada<K,V>> tail;
	protected int size;
	public LinkedPriorityQueue() {
		head = null;
		tail = null;
		size = 0;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(this.size() == 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Entry<K, V> min() {
	    if (isEmpty()) {
	        return null; // Si la cola esta vacia, devuelve null
	    }

	    NodoCola<Entrada<K, V>> actual = head;
	    Entrada<K, V> minEntry = actual.getElement(); // Inicializa minEntry con el primer elemento

	    // Recorre la lista enlazada para encontrar la entrada mínima
	    while (actual != null) {
	        Entrada<K, V> entry = actual.getElement();
	        if (entry.getKey().compareTo(minEntry.getKey()) < 0) {
	            minEntry = entry; // Actualiza minEntry si se encuentra una clave menor
	        }
	        actual = actual.getNext(); // Avanza al siguiente nodo
	    }

	    return minEntry; // Devuelve la entrada con la clave minima
	}

	@Override
	public void insert(K key, V value) {
	    Entrada<K, V> entrada = new Entrada<>(key, value); // Crear una nueva entrada
	    NodoCola<Entrada<K, V>> nodo = new NodoCola<>(entrada, null); // Crear un nuevo nodo

	    if (isEmpty()) {
	        head = nodo;
	        tail = nodo;
	    
	    } else {
	        //busco la posicion correcta para insertar
	        NodoCola<Entrada<K, V>> actual = head;
	        NodoCola<Entrada<K, V>> anterior = null;

	        // recorro la lista para encontrar la posicion de insercion
	        while (actual != null && actual.getElement().getKey().compareTo(key) <= 0) {
	        	anterior = actual;
	            actual = actual.getNext();
	        }

	        // Insertar el nuevo nodo en la posición correcta
	        if (anterior == null) {
	            // Insertar al principio (nuevo nodo tiene la mayor prioridad)
	        	nodo.setNext(head);
	            head = nodo;
	        } else {
	            // Insertar entre anterior y actual
	        	nodo.setNext(actual);
	        	anterior.setNext(nodo);
	        }

	        // Si se insertó al final, actualizar la cola
	        if (actual == null) {
	            tail = nodo;
	        }
	    }

	    size++;
	}

	@Override
	public Entry<K, V> removeMin() {
		// PENDIENTE IMPLEMENTAR
		return null;
	}
	

}
