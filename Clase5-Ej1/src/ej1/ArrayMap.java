package ej1;

public class ArrayMap<K,V> implements Map<K,V> {
	private Entry<K,V>[] array;
	private int size;
	
	public ArrayMap(){
		array = (Entry<K,V>[])new Entrada[100];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size!=0;
	}
	
	public V get(K k) {
		for(int i = 0; i < this.size; i++) {
			if(array[i].getKey() == k) {
				return array[i].getValue();
			}
		}
		return null;
	}
	
	public V put(K k, V v) {
		V aux;
		if (size ==0) {
			array[size] = new Entrada(k,v);
			size++;
		}
		else {
		if(size < array.length) {
		for(int i = 0; i<array.length; i++) {
			if(array[i].getKey() == k) {
				aux = array[i].getValue();
				array[i].setValue(v);
				return aux;
			}
			else {
				array[size] = new Entrada(k,v);
				size++;
				return null;
			}
		}
		}
		else {
			System.out.println("El arreglo está lleno");
		}
		}
		return null;
	}
	
	public V remove(K k) {
		V aux;
		K auxNuevaKey;
		V auxNuevoValue;
		for(int i = 0; i<this.size; i++) {
			if(array[i].getKey() == k) {
				aux = array[i].getValue();
				auxNuevaKey = array[size-1].getKey();
				auxNuevoValue = array[size-1].getValue();
				array[i].setKey(auxNuevaKey);
				array[i].setValue(auxNuevoValue);
				size--;
				return aux;
			}
		}
		return null;
	}
	
	public K[] keys() {
		K[] arrayAux = (K[]) new Object[size];
		for(int i = 0; i < size;i++) {
			arrayAux[i] = array[i].getKey();
		}
		return arrayAux;
	}
	
	public V[] values() {
		V[] arrayAux = (V[]) new Object[size];
		for (int i = 0; i < size; i++) {
			arrayAux[i] = array[i].getValue();
		}
		return arrayAux;
	}
	
	public Entry<K,V>[] entries(){
		Entry<K,V>[] arrayAux = (Entry<K,V>[]) new Entrada[size];
		for (int i = 0; i < size; i++) {
			arrayAux[i] = arrayAux[i] = new Entrada(array[i].getKey(),array[i].getValue());
		}
		return arrayAux;
	}
	
}
