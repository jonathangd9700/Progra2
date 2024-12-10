package clase9;

public class NodoAVL<E> {
	private NodoAVL<E> padre;
	private E elemento;
	private int altura; //diferencia vs ABB
	private boolean eliminado; // diferencia vs ABB
	private NodoAVL<E> izq, der;
	public NodoAVL (E elem, NodoAVL<E> padre){ 
		altura = 0; 
		eliminado = false;
		this.elemento = elem;
		this.padre = padre;
		izq = der = null;
	}
	public E getElemento() { return elemento; }
	public NodoAVL<E> getPadre() { return padre; }
	public NodoAVL<E> getIzq() { return izq; }
	public NodoAVL<E> getDer() { return der; }
	public int getAltura() {return altura;}
	public boolean getEliminado() {return eliminado;}
	public void setElemento( E element ) { this.elemento = element; }
	public void setIzq( NodoAVL<E> izq ) { this.izq = izq; }
	public void setDer( NodoAVL<E> der ) { this.der = der; }
	public void setPadre( NodoAVL<E> padre ) { this.padre = padre; }
	public void setAltura(int alt) {this.altura=alt;}
	public void setEliminado(boolean elim) {this.eliminado=elim;}
}
