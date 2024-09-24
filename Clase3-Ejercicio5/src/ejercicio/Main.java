package ejercicio;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaArreglo<Integer> pila1 = new PilaArreglo<Integer>();
		
		pila1.push(1);
		pila1.push(2);
		pila1.push(3);
		pila1.push(4);
		pila1.push(5);
		pila1.push(6);
		pila1.push(7);
		pila1.push(8);
		pila1.push(9);
		pila1.push(10);
		
		System.out.println(pila1.size());
		//pila1.imprimirElementos();
		
		pila1.invertir(pila1);
		pila1.imprimirElementos();
	}

	
}
