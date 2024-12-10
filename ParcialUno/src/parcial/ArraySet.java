package parcial;

public class ArraySet<E> implements Set<E>{
	
	private E[] array;
    private int size;
    @SuppressWarnings("unchecked")
	public ArraySet() {
        array = (E[]) new Object[100];
        size = 0;
    }
    @SuppressWarnings("unchecked")
	public ArraySet(int initialSize) {
        array = (E[]) new Object[initialSize];
        size = 0;
    }
	
	public void insertar(E element) {
        if (size == array.length) {
            resizeArray();
        }
        if(!member(element)) {
            array[size] = element;
            size++;
        }
	}
	
    private void resizeArray() {
        @SuppressWarnings("unchecked")
		E[] newArray = (E[]) new Object[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    
	public void delete(E x) {
		
		if(member(x)) {
			if(x==(array[size - 1])) {
				size--;
			}
			else {
				int pos = posicion(x);
				E aux = array[size - 1];
				array[size-1] = array[pos];
				array[pos] = aux;
				size--;
				
			}
		
		}
	}
	
	private int posicion(E x) {
		int i = 0;
		while(i<size) {
			if(array[i].equals(x)) {
				return i;
			}
			i++;
		}
		return i;
	}
	
	public boolean member(E x) {
		int i = 0;
		while(i<size) {
			if(array[i].equals(x)) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	public Set<E> intersection(Set<E> S){
		ArraySet<E> interseccion = new ArraySet<E>();
		for(int i = 0; i<size; i++) {
			if(S.member(array[i])) {
				interseccion.insertar(array[i]);
			}
		}
		return interseccion;
	}
	
	
	public Set<E> union(Set<E> S) {
		ArraySet<E> union = new ArraySet<E>();
		LinkedList<E> set2 = S.values();
		E aux = set2.elementAt(0);
		System.out.println("Ver aux"+aux);
		for(int a = 0; a < size; a ++) {
			if(!S.member(array[a])) {
				union.insertar(array[a]);
				}
			}
		
		for(int i = 0; i < set2.getSize();i++) {
			if(!union.member(aux)) {
				union.insertar(aux);
			}
			aux = set2.elementAt(i);
		}
		
		
		return union;
	}
	
	public LinkedList<E> values(){
		LinkedList<E> lista = new LinkedList<E>();
		if(size > 0) {
			for(int i = 0; i < size; i++) {
				lista.addFirst(array[i]);
			}
		}
		return lista;
	}


	
}
