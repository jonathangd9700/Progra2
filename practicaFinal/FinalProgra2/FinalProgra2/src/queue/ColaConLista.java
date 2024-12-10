package queue;


public class ColaConLista<E> implements Queue<E> {
	protected NodoCola<E> head;
	protected NodoCola<E> tail;
	protected int size;
	//constructor
	public ColaConLista(){
		head=null; tail=null; size=0;
	}
	//metodos
	public int size(){return size;}
	public boolean isEmpty(){return size==0;}
	public E front() throws MyException{
		if(isEmpty())throw new MyException("Esta vacia");
		return head.getElement();
	}
	public void enqueue(E elem){
		NodoCola<E> aux=new NodoCola<E>(elem,null);
		if(size==0)head=aux;
		else tail.setNext(aux);
		tail=aux;
		size++;
	}
	public E dequeue()throws MyException{
		if(size==0)throw new MyException("Esta vacia");
		E aux=head.getElement();
		NodoCola<E>aux2=head;
		head=aux2.getNext();
		aux2.setNext(null);
		size--;
		if(size==0)tail=null;
		return aux;
	}
}

