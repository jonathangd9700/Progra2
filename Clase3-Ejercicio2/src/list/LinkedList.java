package list;


public class LinkedList {
	private Node head;
	private int size;
	private Node actual;
	
	public LinkedList() {
		head = null;
		size = 0;
		actual = null;
	}
	
	public int getHeadElement() {
		return (int) head.getElement();
	}
	
	public void agregarElementoInicio(Node n) {
		n.setNext(head);
		head = n;
		size++;
	}
	
	public void agregarElementoInicio(int elemento) {
		Node aux = new Node(elemento);
		agregarElementoInicio(aux);
		actual = aux;
	}
	
	public void agregarElementoFinal(Node n) {
		//Si es el primer elemento head = null => head = n, 
		if(head== null) {
			head = n;	
		}
		else {
			head.setNext(n);
		}
		size++;
	}
	
	public void agregarElementoFinal(int elemento) {
		Node aux = new Node(elemento);
		agregarElementoFinal(aux);
		actual = aux;
	}
	
	public void eliminarPrimero() {
		Node aux = head.getNext();
		head.setNext(null);
		head = aux;
		size--;
	}
	
	public Node verActual() {
		return actual;
	}
	
	public void imprimirElementosNodos() {
		Node actual = head;
        
        while (actual != null) {
            System.out.println(actual.getElement());
            actual = actual.getNext();
		}
	}
}
