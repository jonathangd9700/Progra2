package list;


public class LinkedList {
	private Node head;
	private Node last;
	private int size;
	private Node actual;
	
	public LinkedList() {
		head = null;
		last = null;
		size = 0;
		actual = null;
	}
	
	public int getHeadElement() {
		return (int) head.getElement();
	}
	
	public void agregarElementoInicio(Node n) {
		if(head == null) {
			head = n;
			last = n;
		}
		else {
			n.setNext(head);
			head = n;
			for(int i = 0; i < size; i++) {
				if (n.getNext() == null) {
					last = n;
				}
			}
		}
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
			last = n;
		}
		else {
			last.setNext(n);
			last = n;
			
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
