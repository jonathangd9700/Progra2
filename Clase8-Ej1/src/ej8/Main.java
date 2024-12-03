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
		arbol.insertar(4);
		arbol.insertar(12);
		arbol.insertar(55);
		arbol.insertar(35);
		
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
		
	//Ejercicio 4---------------------------------------------------
		
		/*
		Integer elemento= arbol.min();
		System.out.println(elemento);
		*/
		
		//Ejercicio 5 ----------------------------------------------
		
		/*
		String array4 = arbol.nivelesImpresos();
		
		System.out.println(array4);
		*/
		
		//Ejercicio 6 ---------------------------------------------
		/*
		System.out.println("La altura del arbol es: " + arbol.alturaABB());
		*/
		//System.out.println(arbol.pruebaNodoizq());
		
		
		ArrayDictionary<Integer,String> arrayMultiple = new ArrayDictionary<Integer,String>();
		
		System.out.println(arrayMultiple.isEmpty());
		
		arrayMultiple.put(4, "Hola");
		arrayMultiple.put(4, "Chau");
		arrayMultiple.put(6, "123");
		arrayMultiple.put(6, "456");
		Object[] arrayValues = arrayMultiple.get(4);
		Object[] arrayValues2 = arrayMultiple.get(6);
		for(int i = 0; i < arrayValues.length; i++) {
			System.out.println(arrayValues[i]);
		}
		for(int i = 0; i < arrayValues2.length; i++) {
			System.out.println(arrayValues2[i]);
		}
		System.out.println(arrayMultiple.isEmpty());
		
	}
}
