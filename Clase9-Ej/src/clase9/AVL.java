package clase9;

import java.util.Comparator;

public class AVL<E extends Comparable<E>> implements AVLTDA<E>   {
	protected NodoAVL<E> raiz;
	protected int size;
	Comparator<E> comp;
	//CONSTRUCTOR
	public AVL(Comparator<E> comp) { 
		raiz = new NodoAVL<E>(null,null); 
		size = 0;
		this.comp = comp;
	}
	//PERTENECE ES IGUAL A ABB
	public boolean pertenece( E elemento ) { 
		return buscar(elemento).getElemento() != null; 
	}
	private NodoAVL<E> buscar( E elemento ) {
		return buscarAux( elemento, raiz );
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
		insertaux( raiz, x );
	}
	private int max(int i, int j )
	{
		return i>j ? i : j;
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
			if( comparacion == 0 ) {  
				t.setElemento( item ); // Acá definimos que hacemos cuando el elemento a insertar ya estaba
			}
			else {
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
					if( comp_item_y < 0 )  {
						rotacion_I(t);   // item < y => rotacion (i)
					}
					else { 
						rotacion_II(t);  // item > y => rotacion (ii)
					}
					
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
	}
	
	public E eliminar(E elemento) {
		return elemento;
	}
	//ENCONTRAR MINIMO
	
	public NodoAVL<E> obtenerMinimo() {
		System.out.println(minRec(raiz).getElemento());
		return minRec(raiz);
	}
	
	private NodoAVL<E> minimo(NodoAVL<E> nodo) {
		while(nodo.getElemento() != null) {
			nodo = nodo.getIzq();
		}
		return nodo.getPadre();
	}
	
	//Minimo de forma recursiva
	private NodoAVL<E> minRec(NodoAVL<E> nodo){
		if(nodo.getElemento()== null) {
			return nodo.getPadre();
		}
		else {
			return minRec(nodo.getIzq());
		}
	}
	
	//ALTURA para encontrar la altura encuentro el mínimo y el máximo que son los últimos nodos de cada sub arbol (izq y der). Tomo la altura de esos nodos y la más alta la devuelvo
	private NodoAVL<E> maxRec(NodoAVL<E> nodo){
		if(nodo.getElemento()== null) {
			return nodo.getPadre();
		}
		else {
			return maxRec(nodo.getDer());
		}
	}
	
	public NodoAVL<E> maximo(){
		return maxRec(raiz);
	}
	
	private int calcAltura(NodoAVL<E> min, NodoAVL max) {
		if(min.getAltura() < max.getAltura()) {
			return max.getAltura();
		}
		else {
			return min.getAltura();
		}
	}
	
	public int calcularAltura() {
		return raiz.getAltura();
	}
	
	private void rotacion_I(NodoAVL<E> nodo) {
		NodoAVL<E> abuelo = nodo.getPadre();
	}
	private void rotacion_II(NodoAVL<E> nodo) {
		
	}
	private void rotacion_III(NodoAVL<E> nodo) {
		
	}
	private void rotacion_IV(NodoAVL<E> nodo) {
		
	}
	/*
	private void rotacion_I(NodoAVL<E> nodo) {
	
	    NodoAVL<E> hijoIzq = nodo.getIzq();
	    reemplazarNodo(nodo, hijoIzq);
	    nodo.setIzq(hijoIzq.getDer());
	    if (hijoIzq.getDer() != null) {
	        hijoIzq.getDer().setPadre(nodo);
	    }
	    hijoIzq.setDer(nodo);
	    nodo.setPadre(hijoIzq);

	    
	    nodo.setAltura(Math.max(obtenerAltura(nodo.getIzq()), obtenerAltura(nodo.getDer())) + 1);
	    hijoIzq.setAltura(Math.max(obtenerAltura(hijoIzq.getIzq()), nodo.getAltura()) + 1);
	}

	private void rotacion_II(NodoAVL<E> nodo) {
	    rotacion_III(nodo.getIzq());
	    rotacion_I(nodo);
	}
	
	private void rotacion_III(NodoAVL<E> nodo) {
		
		
	    NodoAVL<E> hijoDer = nodo.getDer();
	    reemplazarNodo(nodo, hijoDer);
	    nodo.setDer(hijoDer.getIzq());
	    if (hijoDer.getIzq() != null) {
	        hijoDer.getIzq().setPadre(nodo);
	    }
	    hijoDer.setIzq(nodo);
	    nodo.setPadre(hijoDer);

	    
	    nodo.setAltura(Math.max(obtenerAltura(nodo.getIzq()), obtenerAltura(nodo.getDer())) + 1);
	    hijoDer.setAltura(Math.max(obtenerAltura(hijoDer.getDer()), nodo.getAltura()) + 1);
	}

	private void rotacion_IV(NodoAVL<E> nodo) {
	    rotacion_I(nodo.getDer());
	    rotacion_III(nodo);
	}
	
	public E eliminar(E elemento) {
	    NodoAVL<E> nodoEliminar = buscar(elemento);
	    if (nodoEliminar == null || nodoEliminar.getElemento() == null) {
	        return null; 
	    }
	    E eliminado = nodoEliminar.getElemento();
	    eliminarNodo(nodoEliminar);
	    size--;
	    return eliminado;
	}
	
	
	private void reemplazarNodo(NodoAVL<E> nodoActual, NodoAVL<E> nuevoNodo) {
	    if (nodoActual.getPadre() == null) {
	        raiz = nuevoNodo;
	    } else {
	        if (nodoActual == nodoActual.getPadre().getIzq()) {
	            nodoActual.getPadre().setIzq(nuevoNodo);
	        } else {
	            nodoActual.getPadre().setDer(nuevoNodo);
	        }
	    }
	    if (nuevoNodo != null) {
	        nuevoNodo.setPadre(nodoActual.getPadre());
	    }
	}
	
	private void eliminarNodo(NodoAVL<E> nodo) {
	    if (nodo.getIzq().getElemento() == null && nodo.getDer().getElemento() == null) { 
	        reemplazarNodo(nodo, null);
	        rebalancear(nodo.getPadre());
	    } else if (nodo.getIzq().getElemento() == null) { 
	        reemplazarNodo(nodo, nodo.getDer());
	        rebalancear(nodo.getDer());
	    } else if (nodo.getDer().getElemento() == null) { 
	        reemplazarNodo(nodo, nodo.getIzq());
	        rebalancear(nodo.getIzq());
	    } else { 
	        NodoAVL<E> sucesor = minimo(nodo.getDer());
	        nodo.setElemento(sucesor.getElemento());
	        eliminarNodo(sucesor);
	    }
	}
	
	private void rebalancear(NodoAVL<E> nodo) {
	    while (nodo != null) {
	        actualizarAltura(nodo);
	        int balance = obtenerBalance(nodo);

	        if (balance > 1) { 
	            if (obtenerBalance(nodo.getIzq()) >= 0) {
	                rotacion_I(nodo);
	            } else {
	                rotacion_II(nodo);
	            }
	        } else if (balance < -1) { 
	            if (obtenerBalance(nodo.getDer()) <= 0) {
	                rotacion_III(nodo);
	            } else {
	                rotacion_IV(nodo);
	            }
	        }
	        nodo = nodo.getPadre();
	    }
	}
	
	private void actualizarAltura(NodoAVL<E> nodo) {
	    nodo.setAltura(Math.max(obtenerAltura(nodo.getIzq()), obtenerAltura(nodo.getDer())) + 1);
	}
	
	private int obtenerBalance(NodoAVL<E> nodo) {
	    return obtenerAltura(nodo.getIzq()) - obtenerAltura(nodo.getDer());
	}
	
	private int obtenerAltura(NodoAVL<E> nodo) {
	    if (nodo == null || nodo.getElemento() == null) {
	        return 0;
	    }
	    return nodo.getAltura();
	}
	*/
}
