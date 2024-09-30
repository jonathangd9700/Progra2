package DinamicQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue<Integer> cola = new LinkedQueue<Integer>();
		
		cola.enqueue(4);
		cola.enqueue(75);
		cola.enqueue(5);
		cola.enqueue(74);
		System.out.println(cola.dequeue());
		System.out.println(cola.dequeue());
		System.out.println(cola.dequeue());
		System.out.println(cola.dequeue());
		System.out.println(cola.dequeue());
		System.out.println(cola.front());


	}

}
