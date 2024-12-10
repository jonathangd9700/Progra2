package priorityQueue;

public class NodoCola<E>{
	private E dato;
	private NodoCola<E> next;
	//constructor
	public NodoCola(E d, NodoCola<E> n){
		dato=d; next=n;}
	//metodos
	public E getElement(){return dato;}
	public NodoCola<E> getNext(){return next;}
	public void setElement(E d){dato=d;}
	public void setNext(NodoCola<E> n){next=n;}
}
