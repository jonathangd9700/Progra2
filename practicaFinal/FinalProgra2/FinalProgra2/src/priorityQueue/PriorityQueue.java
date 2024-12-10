package priorityQueue;

public interface PriorityQueue<K,V> {
	public int size(); //devuelve la cantidad de elementos en la cola
	public boolean isEmpty(); //devuelve verdadero si la cola está vacía, sino falso
	public Entry<K,V> min(); //devuelve pero no elimina el elemento más chico
	public void insert(K key, V value); //agrega el element V con prioridad K en la cola
	public Entry<K,V> removeMin(); //elimina el elemento más chico
 }
