package ej8;

import java.lang.reflect.Array;
import java.util.Comparator;
public class arbolBB<E extends Comparable<E>> implements ABBTDA<E> {
	protected NodoABB<E> raiz;
	protected int size;
	protected int index;
	Comparator<E> comp;
	//CONSTRUCTOR
	public arbolBB(Comparator<E> comp) { 
		raiz = new NodoABB<E>(null,null); 
		size = 0;
		this.comp = comp;
	}
	
	//PARA BUSCAR UN ELEMENTO
	public boolean pertenece( E elemento ) { 
		return buscar(elemento).getElemento() != null; 
	}
	private NodoABB<E> buscar( E elemento ) {
		return buscarAux( elemento, raiz );
	}
	private NodoABB<E> buscarAux( E elemento, NodoABB<E> nodov ) {
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
	
	//PARA INSERTAR UN ELEMENTO
	public void insertar( E elemento ) {
		NodoABB<E> nodov = buscar( elemento );
		if( nodov.getElemento() == null ) {
			nodov.setElemento( elemento );
			nodov.setIzq( new NodoABB<E>( null, nodov ) );
			nodov.setDer( new NodoABB<E>( null, nodov ) );
			size++;
		}
	}
	
	//La solución anterior es más simple pero podía ir por la alternativa
	//insertar alternativo recursivo como lo vimos en clase:
	public void insertar2( E elemento ) {
		insertarAux( elemento, raiz ); 
	}
	private void insertarAux( E elemento, NodoABB<E> nodov ) {
		if( nodov.getElemento() == null ) {
			nodov.setElemento( elemento ); size++;
			nodov.setIzq( new NodoABB<E>( null, nodov ) );
			nodov.setDer( new NodoABB<E>( null, nodov ) );
		} 
		else {
			int c = comp.compare( elemento, nodov.getElemento() );
			if( c == 0 ) {  /* ¿Qué hacemos si el elemento ya está? */ }
			else 
				if( c < 0 ) 
					insertarAux( elemento, nodov.getIzq() );
				else 
					insertarAux( elemento, nodov.getDer() );
		}
	}
	 
	//PARA ELIMINAR UN ELEMENTO
	// retorna null si no pudo eliminar a k, retorna k si la pudo eliminar
	public E eliminar( E elemento ) {
		NodoABB<E> p = buscar( elemento );
		if( p.getElemento() != null ) {
			E eliminado = p.getElemento();
			eliminarAux( p );
			size--;
			return eliminado;
		} 
		else 
			return null;
	}
	private boolean isExternal( NodoABB<E> p ) { 
		return p.getIzq().getElemento() == null && p.getDer().getElemento() == null; 
	}
	private boolean soloTieneHijoIzquierdo( NodoABB<E> p ) {
		return p.getIzq().getElemento() != null &&  p.getDer().getElemento() == null;
	}
	private boolean soloTieneHijoDerecho( NodoABB<E> p ) {
		return p.getDer().getElemento() != null && p.getIzq().getElemento() == null;
	}
	
	private void eliminarAux( NodoABB<E> p ) {
		if( isExternal(p) ) {  // p es hoja: Convertir el nodo en un dummy y soltar sus hijos dummy.
			p.setElemento( null );  
			p.setIzq( null );  
			p.setDer( null );
		}
		else {  // p no es hoja
			if( soloTieneHijoIzquierdo(p) ) {
				// Enganchar al padre de p con el hijo izquierdo de p
				if( p.getPadre().getIzq() == p ) // p es el hijo izquierdo de su padre
					p.getPadre().setIzq( p.getIzq() );  // el hijo izq del padre de p es ahora el hijo de p
				else // p es el hijo derecho de su padre
					p.getPadre().setDer( p.getIzq() ); // el hijo derecho del padre de p es el hijo de p
				p.getIzq().setPadre( p.getPadre() ); // Ahora el padre del hijo izq de p es su abuelo
			} 
			else 
				if( soloTieneHijoDerecho(p) ) {
					// Enganchar al padre de p con el hijo derecho de p
					if( p.getPadre().getIzq() == p ) // p es hijo izquierdo de su padre
						p.getPadre().setIzq( p.getDer() ); // el hijo izq del padre de p es el hijo de p
					else
						p.getPadre().setDer( p.getDer() ); // el hijo derecho del padre de p es el hijo de p
					p.getDer().setPadre( p.getPadre() ); // Ahora el padre del hijo der. de p es su abuelo
				} 
				else { // p tiene dos hijos: seteo como rótulo de p al rótulo del sucesor inorder de p.
					p.setElemento( eliminarMinimo( p.getDer() ) );
				}
		}	
	}
	
	// Elimina el nodo con elemento mínimo del subárbol que tiene como raíz a p
	// El mínimo rótulo del subárbol que tiene como raíz a p es el rótulo del primer nodo que 
	// encuentro yendo a la izquierda que no tiene hijo izquierdo 
	private E eliminarMinimo( NodoABB<E> p ) {
		if( p.getIzq().getElemento() == null ) {  // El hijo izquierdo de p es un dummy
			E aRetornar = p.getElemento();  // salvo el rótulo a devolver
			if( p.getDer().getElemento() == null ) { // p es hoja (pues sus hijos son dummy)
				p.setElemento( null ); // Convierto a p en dummy haciendo nulo su rótulo
				p.setIzq( null ); // y desenganchando sus dos hijos dummy
				p.setDer( null );
			} 
			else { 
				// p solo tiene hijo derecho (xq no tiene izquierdo)
				// Engancho al padre de p con el hijo derecho de p.
				// Seguro tiene que ser el hijo derecho de su padre.
				p.getPadre().setDer( p.getDer() );
				p.getDer().setPadre( p.getPadre() );
			}
			return aRetornar;
		} 
		else { // Si p tiene hijo izquierdo, entonces p.getRotulo() no es el mínimo.
			// El mínimo tiene que estar en el subárbol izquierdo
			return eliminarMinimo( p.getIzq() );
		}
	
	}

	//un método para mostrar el árbol
	public String toString() {
		return inorder( raiz );
	}
	private String inorder( NodoABB<E> nodov ) {
		if( nodov.getElemento() != null ) {
			return "(" + inorder( nodov.getIzq()) + nodov.getElemento() + inorder( nodov.getDer() ) + ")";
		}	 
		else return "";
	}

//•	Agregar un método elementosPre que devuelve un arreglo con los elementos del árbol ordenados por un recorrido pre-order.
//•	Agregar un método elementosIn que devuelve un arreglo con los elementos del árbol ordenados por un recorrido in-order.
//•	Agregar un método elementosPost que devuelve un arreglo con los elementos del árbol ordenados por un recorrido post-order.
	
	public String toStringPre() {
		return preorder( raiz );
	}
	
	private String preorder( NodoABB<E> nodov ) {
		if( nodov.getElemento() != null ) {
			return "("  + nodov.getElemento() + preorder( nodov.getIzq()) + preorder( nodov.getDer() ) + ")";
		}	 
		else return "";
	}	
	
	public String toStringPos() {
		return posorder( raiz );
	}			
	
	private String posorder( NodoABB<E> nodov ) {
		if( nodov.getElemento() != null ) {
			return "("   + posorder( nodov.getIzq()) + posorder( nodov.getDer() ) + nodov.getElemento() + ")";
		}	 
		else return "";
	}
	
	public E[] elementosPre() {
	    E[] array = (E[]) new Comparable[size];
	    index = 0;
	    preOrderTraversal(raiz, array);
	    return array;
	}

	private void preOrderTraversal(NodoABB<E> nodo, E[] elementos) {
	    if (nodo.getElemento() != null) {
	        elementos[index] = nodo.getElemento();
	        index++;
	        preOrderTraversal(nodo.getIzq(), elementos);
	        preOrderTraversal(nodo.getDer(), elementos);
	    }
	}
	
	public E[] elementoIn() {
	    E[] array = (E[]) new Comparable[size];
	    index = 0;
	    inOrderTraversal(raiz, array);
	    return array;
	}
	
	private void inOrderTraversal(NodoABB<E> nodo, E[] elementos) {
	    if (nodo.getElemento() != null) {
	        inOrderTraversal(nodo.getIzq(), elementos);
	        elementos[index] = nodo.getElemento();
	        index++;
	        inOrderTraversal(nodo.getDer(), elementos);
	    }
	}
	
	public E[] elementoPos() {
	    E[] array = (E[]) new Comparable[size];
	    index = 0;
	    posOrderTraversal(raiz, array);
	    return array;
	}
	
	private void posOrderTraversal(NodoABB<E> nodo, E[] elementos) {
	    if (nodo.getElemento() != null) {
	        posOrderTraversal(nodo.getIzq(), elementos);
	        posOrderTraversal(nodo.getDer(), elementos);
	        elementos[index] = nodo.getElemento();
	        index++;
	    }
	}
	
	public E min() {
		E elemento = minimoElemento(raiz);
		return elemento;
	}
	
	private E minimoElemento(NodoABB<E> nodo) {
		
		if(nodo.getElemento() ==null) {
			NodoABB<E> nodoDummyIzqPadre = nodo.getPadre(); 
			return nodoDummyIzqPadre.getElemento();
		}
		else {
			return minimoElemento(nodo.getIzq());		
		}
		
	}
}



	

