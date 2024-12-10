package avl;

import java.util.Comparator;

import priorityQueue.Entry;

@SuppressWarnings("unused")
public class AVL<E extends Comparable<E>> implements AVLTDA<E>   {
	private NodoAVL<E> raiz;
	private int size;
	Comparator<E> comp;
	//CONSTRUCTOR
	public AVL(Comparator<E> comp) { 
		setRaiz(new NodoAVL<E>(null,null)); 
		setSize(0);
		this.comp = comp;
	}
	//PERTENECE ES IGUAL A ABB
	public boolean pertenece( E elemento ) { 
		return buscar(elemento).getElemento() != null; 
	}
	private NodoAVL<E> buscar( E elemento ) {
		return buscarAux( elemento, getRaiz() );
	}
	private NodoAVL<E> buscarAux( E elemento, NodoAVL<E> nodov ) {
		 if( nodov.getElemento() == null ) 
			 return nodov;
		 else{
			 int c = comp.compare( elemento, nodov.getElemento() );
			 if( c == 0 ) return nodov;
			 else 
				 if( c < 0 ) 
					 return buscarAux( elemento, nodov.getIzq() );
				 else 
					 return buscarAux( elemento, nodov.getDer() );
		 }
	}
	
	//VEAMOS AHORA LOS CAMBIOS EN INSERTAR
	public void insertar(E x)
	{
		insertaux( getRaiz(), x );
	}
	
	private int max(int i, int j )
	{
		return i>j ? i : j;
	}
	
	
	private NodoAVL<E> encontrarMin(NodoAVL<E> nodo) {
	    while (nodo.getIzq().getElemento() != null) {
	        nodo = nodo.getIzq();
	    }
	    return nodo;
	}
	
	public E findMin() {
	    if (raiz == null || raiz.getElemento() == null) {
	        return null;
	    }
	    NodoAVL<E> nodoActual = raiz;
	    while (nodoActual.getIzq() != null && nodoActual.getIzq().getElemento() != null) {
	        nodoActual = nodoActual.getIzq();
	    }
	    return nodoActual.getElemento();
	}


	public E findMax() {
	    if (raiz == null || raiz.getElemento() == null) {
	        throw new MyException("El árbol está vacío");
	    }
	    NodoAVL<E> actual = raiz;
	    while (actual.getDer() != null && actual.getDer().getElemento() != null) {
	        actual = actual.getDer();
	    }
	    return actual.getElemento();
	}

	public E extractMin() {
	    if (raiz == null || raiz.getElemento() == null) {
	        throw new MyException("El árbol está vacío");
	    }
	    NodoAVL<E> actual = raiz;
	    NodoAVL<E> padre = null;
	    
	    // Navegar hasta el nodo más a la izquierda
	    while (actual.getIzq() != null && actual.getIzq().getElemento() != null) {
	        padre = actual;
	        actual = actual.getIzq();
	    }

	    E minElemento = actual.getElemento();
	    eliminar(actual.getElemento()); // Llamar al método eliminar previamente implementado
	    return minElemento;
	}

	public int size() {
	    return size;
	}

	public boolean isEmpty() {
	    return (size == 0);
	}

	
	private void insertaux( NodoAVL<E> t, E item ) {
		if( t.getElemento() == null )  {
			t.setElemento( item );
			t.setAltura( 1 );
			t.setIzq( new NodoAVL<E>( null, t ) );
			t.setDer( new NodoAVL<E>( null, t ) );  
		}  
		else {
			int comparacion = comp.compare( item, t.getElemento() );
			if( comparacion == 0 )  
				t.setElemento( item ); // Acá definimos que hacemos cuando el elemento a insertar ya estaba
			else 
				if( comparacion < 0 ) {
					insertaux( t.getIzq(), item );
					//Solucionada la inserción, el próximo bloque es para mantener la propiedad de altura AVL
					if( Math.abs( t.getIzq().getAltura() - t.getDer().getAltura() ) > 1 ) {
					// Rebalancear mediante rotaciones:  testeo por rotaciones (i) o (ii)
					// Si estoy aca => item < x (mi elemento), debo testear si (item < y) o (item > y) siendo y elemento de mi hijo izq
					// si item < y => rotacion (i);       
					// si item > y => rotacion (ii)
					E y = t.getIzq().getElemento();
					int comp_item_y = comp.compare( item, y );
					if( comp_item_y < 0 )  
						rotacion_I(t);   // item < y => rotacion (i)
					else 
						rotacion_II(t);  // item > y => rotacion (ii)
					}  
				}
				else { 
					insertaux( t.getDer(), item );
					if( Math.abs( t.getIzq().getAltura() - t.getDer().getAltura() ) > 1 ) {
						// Rebalancear mediante rotaciones:  testeo por rotaciones (i) o (ii)
						// Si estoy aca => item < x (mi elemento), debo testear si (item < y) o (item > y) siendo y elemento de mi hijo izq
						// si item < y => rotacion (IV);       
						// si item > y => rotacion (III)
						E y = t.getDer().getElemento();
						int comp_item_y = comp.compare( item, y );
						if( comp_item_y < 0 )  
							rotacion_IV(t);   // item < y => rotacion (IV)
						else 
							rotacion_III(t);  // item > y => rotacion (III)
					}
				} 
				//Modifico la altura del nodo
				t.setAltura( max(t.getIzq().getAltura(), t.getDer().getAltura()) + 1 );
		}  
	}

	
	private void rotacion_I(NodoAVL<E> raizSubArbol) {
		//obtengo 7
		NodoAVL<E> HijoIzq = raizSubArbol.getIzq();
		//obtengo el 5
		NodoAVL<E> Abuelo = raizSubArbol.getPadre();
		//A 7 le asigno el padre de 8, osea 5
		HijoIzq.setPadre(Abuelo);
		//a 5 le asigno el 7 como hijo derecho
		Abuelo.setDer(HijoIzq);
		//a 7 le asigno 8 como hijo derecho
		HijoIzq.setDer(raizSubArbol);
		//a 8 le asigno 7 como padre, deja de ser 5
		raizSubArbol.setPadre(HijoIzq);
		//a 8 le quitamos 7 como hijo izq y dejamos dummy
		raizSubArbol.setIzq(new NodoAVL<E>(null,raizSubArbol));
		//actualizamos la altura de 8
		raizSubArbol.setAltura(max(raizSubArbol.getIzq().getAltura(), raizSubArbol.getDer().getAltura()) + 1);
		//actualizamos la altura de 7
		HijoIzq.setAltura(max(HijoIzq.getIzq().getAltura(), HijoIzq.getDer().getAltura()) + 1);
		
		
	}
	private void rotacion_II(NodoAVL<E> raizSubArbol) {
		rotacion_III(raizSubArbol.getIzq());
		rotacion_I(raizSubArbol);
	}
	
	private void rotacion_III(NodoAVL<E> raizSubArbol) {
	    NodoAVL<E> hijoDer = raizSubArbol.getDer(); // Hijo derecho del nodo 
	    NodoAVL<E> abuelo = raizSubArbol.getPadre(); // Padre del nodo a rotar

	    // Actualizamos las referencias
	    hijoDer.setPadre(abuelo);
	    if (abuelo != null) {
	        if (abuelo.getIzq() == raizSubArbol) {
	            abuelo.setIzq(hijoDer);
	        } else {
	            abuelo.setDer(hijoDer);
	        }
	    } else {
	        setRaiz(hijoDer); // Si no tiene padre, significa que es la nueva raíz
	    }

	    // Hacemos que el hijo izquierdo de hijo derecho sea el nuevo hijo derecho de raiz
	    raizSubArbol.setDer(hijoDer.getIzq());
	    if (hijoDer.getIzq() != null) {
	        hijoDer.getIzq().setPadre(raizSubArbol);
	    }

	    // Actualizamos el padre del hijo derecho de raiz` al hijo derecho
	    hijoDer.setIzq(raizSubArbol);
	    raizSubArbol.setPadre(hijoDer);

	    // Actualizamos las alturas
	    raizSubArbol.setAltura(max(raizSubArbol.getIzq().getAltura(), raizSubArbol.getDer().getAltura()) + 1);
	    hijoDer.setAltura(max(hijoDer.getIzq().getAltura(), hijoDer.getDer().getAltura()) + 1);
	}



	private void rotacion_IV(NodoAVL<E> raizSubArbol) {
	    rotacion_I(raizSubArbol.getDer()); 
	    rotacion_III(raizSubArbol);
	}

	
	public E eliminar(E elemento) {
	    NodoAVL<E> nodoAEliminar = buscar(elemento);
	    if (nodoAEliminar == null || nodoAEliminar.getElemento() == null) {
	        return null; // Elemento no encontrado
	    }
	    E eliminado = nodoAEliminar.getElemento();
	    setRaiz(eliminarNodo(getRaiz(), elemento));
	    return eliminado;
	}

	private NodoAVL<E> eliminarNodo(NodoAVL<E> nodo, E elemento) {
	    if (nodo == null || nodo.getElemento() == null) {
	        return nodo;
	    }

	    int comparacion = comp.compare(elemento, nodo.getElemento());

	    if (comparacion < 0) {
	        nodo.setIzq(eliminarNodo(nodo.getIzq(), elemento));
	    } else if (comparacion > 0) {
	        nodo.setDer(eliminarNodo(nodo.getDer(), elemento));
	    } else {
	        // Nodo encontrado
	        if (nodo.getIzq().getElemento() == null) {
	            return nodo.getDer();
	        } else if (nodo.getDer().getElemento() == null) {
	            return nodo.getIzq();
	        } else {
	            // Nodo con dos hijos
	            NodoAVL<E> sucesor = encontrarMin(nodo.getDer());
	            nodo.setElemento(sucesor.getElemento());
	            nodo.setDer(eliminarNodo(nodo.getDer(), sucesor.getElemento()));
	        }
	    }

	    // Actualizar la altura y balancear el nodo
	    nodo.setAltura(1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer())));
	    return balancear(nodo);
	}

	private NodoAVL<E> balancear(NodoAVL<E> nodo) {
	    int balance = obtenerBalance(nodo);

	    // Rotación derecha
	    if (balance > 1 && obtenerBalance(nodo.getIzq()) >= 0) {
	        rotacion_I(nodo);
	    }

	    // Rotación izquierda-derecha
	    if (balance > 1 && obtenerBalance(nodo.getIzq()) < 0) {
	        rotacion_II(nodo);
	    }

	    // Rotación izquierda
	    if (balance < -1 && obtenerBalance(nodo.getDer()) <= 0) {
	        rotacion_III(nodo);
	    }

	    // Rotación derecha-izquierda
	    if (balance < -1 && obtenerBalance(nodo.getDer()) > 0) {
	        rotacion_IV(nodo);
	    }

	    return nodo;
	}


	private int altura(NodoAVL<E> nodo) {
	    return nodo == null ? -1 : nodo.getAltura();
	}

	private int obtenerBalance(NodoAVL<E> nodo) {
	    return nodo == null ? 0 : altura(nodo.getIzq()) - altura(nodo.getDer());
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public NodoAVL<E> getRaiz() {
		return raiz;
	}
	public void setRaiz(NodoAVL<E> raiz) {
		this.raiz = raiz;
	}

}
