package cola;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColaArregloCircular<Integer> cola = new ColaArregloCircular<Integer>(3);

		cola.enqueue(4);
		cola.enqueue(5);
		cola.enqueue(6);
		System.out.println(cola.front());
		cola.dequeue();
		System.out.println(cola.front());
		cola.dequeue();
		System.out.println(cola.front());
		cola.dequeue();
		System.out.println(cola.front());

		
		

	}

}
