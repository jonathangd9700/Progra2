package clase9;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVL<Integer> avl = new AVL<Integer>(new DefaultComparator<Integer>());
		
		avl.insertar(33);
		avl.insertar(20);
		avl.insertar(61);
		avl.insertar(12);
		avl.insertar(27);
		
		avl.obtenerMinimo();
		
		System.out.println("La altura del AVL es: "+ avl.calcularAltura());
		
		String uno = "Cha";
		String dos = "Chau";
		
		int resultado = uno.compareTo(dos);
		
		System.out.println(resultado);
		
		int n1 = 5;
		int n2 = 6;
		
		System.out.println(""+Math.abs(n2 - n1));
		
	}

}
