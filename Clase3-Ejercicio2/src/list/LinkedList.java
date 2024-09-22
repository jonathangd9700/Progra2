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
		}
		size++;
	}
	
	public void agregarElementoInicio(int elemento) {
		Node aux = new Node(elemento);
		agregarElementoInicio(aux);
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
	}
	
	public void eliminarPrimero() {
		 if (head == null) {
			 System.out.println("No hay elementos en la lista para eliminar");
		 }
		 else {
				Node aux = head.getNext();
				head.setNext(null);
				head = aux;
				size--;
		 }
	}
	
	public void eliminarFinal() {
			 if (head == null) {
				 System.out.println("No hay elementos en la lista para eliminar");
			 }
			 if (head == last) { 
			        head = null;
			        last = null;
			        size--;
			    } else {
			        Node nodo = head;
			        while (nodo.getNext() != last) {
			            nodo = nodo.getNext();
			        }

			        actual.setNext(null); 
			        last = nodo; 
			        size--;
			    }
	}
	
	public Node verActual() {
		return actual;
	}
	
	public void imprimirElementosNodos() {
		if (head == null) {
			System.out.println("No hay elementos para imprimir");
		}
		else {
			Node nodo = head;
	        
	        while (nodo != null) {
	            System.out.println(nodo.getElement());
	            nodo = nodo.getNext();	
		}
		}
	}
}
