package ejercicio1;

public class Main {

	public static void main(String[] args) {
		
		
		//TESTEANDO FUNCIONALIDADES BASICAS
		
		/* -----------------------
		Ejercicio1 probandoArreglo = new Ejercicio1();
		
		
		probandoArreglo.push(45);
		probandoArreglo.push(4);
		probandoArreglo.push(871);
		probandoArreglo.push(689);
		probandoArreglo.push(1523);
		probandoArreglo.push(745);
		probandoArreglo.push(693);
		probandoArreglo.push(10005);
		probandoArreglo.push(39);
		probandoArreglo.push(7984);


		
		int primerPosLibreArray = probandoArreglo.size();
		System.out.println("Size: "+primerPosLibreArray);
		Object topeArray = probandoArreglo.top();
		System.out.println("Elemento tope del array: "+ topeArray);
		Object sacar = probandoArreglo.pop();
		System.out.println("Elemento quitado del arreglo: "+sacar);
		System.out.println("Verificando elemento borrado, nuevo tope: " + probandoArreglo.top());
		System.out.println("Nuevo size del arreglo: "+probandoArreglo.size());
		System.out.println("Arreglo vacio? "+probandoArreglo.isEmpty());
		
		------------------------------------ */
		
		//-----------------------------------------
		
		//TESTEANDO PUNTOS CRITICOS CON NUEVO ARRAY
		
		
		//VALOR NEGATIVO DE ARRAY
		/*
		Ejercicio1 array2 = new Ejercicio1(-5);
		*/
		
		//DEJAR ESTE PARA LAS PRUEBAS SIGUIENTES
		Ejercicio1 <Integer> array2 = new Ejercicio1<Integer>();
		
		
		//BORRANDO ELEMENTO CON LA PILA VACIA
		
		//array2.pop();
		
		//PIDIENDO TOP CON LA PILA VACIA
		//array2.top();
		
		//PRUEBAS CON UN SOLO ELEMENTO
		/*
		System.out.println("Size: "+array2.size());
		array2.push(45);
		System.out.println(array2.top());
		System.out.println("Size: "+array2.size());
		array2.pop();
		System.out.println(array2.top());
		System.out.println("Size: "+array2.size());
		*/
		
		//INTENTANDO CARGAR MAS ELEMENTOS DE LO PERMITIDO
		
		/*
		array2.push(45);
		array2.push(4);
		array2.push(871);
		array2.push(689);
		array2.push(1523);
		array2.push(745);
		array2.push(693);
		array2.push(10005);
		array2.push(39);
		array2.push(7984);
		array2.push(1523);
		array2.push(745);
		array2.push(693);
		array2.push(10005);
		*/
		

		
	}

}
