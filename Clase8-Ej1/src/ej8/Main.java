package ej8;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		arbolBB<Integer> arbol = new arbolBB<Integer>(new DefaultComparator<Integer>() );
		
		arbol.insertar(10);
		arbol.insertar(2);
		arbol.insertar(13);
		arbol.insertar(11);
		arbol.insertar(15);
		arbol.insertar(1);
		arbol.insertar(5);
		
		//System.out.println(arbol.toString());
		//System.out.println(arbol.toStringPre());
		//System.out.println(arbol.toStringPos());
		
		// EJERCICIO 3 --------------------------------------
		/*
		Comparable[] array = arbol.elementosPre();

		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " - ");
		}
		
		System.out.println();
		
		Comparable[] array2 = arbol.elementoIn();
		
		for(int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " - ");
		}
		
		System.out.println();
		
		Comparable[] array3 = arbol.elementoPos();
	
		for(int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + " - ");
		}
	*/
	
		Integer elemento= arbol.min();
		System.out.println(elemento);
	}
}
