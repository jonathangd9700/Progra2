package ejercicio5;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Persona p1 = new Persona("Ricardo", 100, 457842);
		Persona p2 = new Persona("Jose",67,512045);
		Persona p3 = new Persona("Martin",75,12454);
		Persona p4 = new Persona("Abril", 70,878945126);
		Persona p5 = new Persona("Silvia",72,784541);
		Persona p6 = new Persona("Gaston",105,4587);
		
		PilaArreglo pila1 = new PilaArreglo();
		
		pila1.push(p1);
		pila1.push(p2);
		pila1.push(p3);
		pila1.push(p4);
		pila1.push(p5);
		pila1.push(p6);
		

	}
	
	static void invertir(PilaArreglo A) {
		for(int i = A.size()-1; i>= 0; i--) {
			
		}
		*/
		LinkedList<Character> lista = new LinkedList<Character>();
		LinkedList<Character> listaAux = new LinkedList<Character>();
		String cadena = "aNita lava la tina";
		
		cadena = cadena.replace(" ", "");
		for(int i = cadena.length()-1;i>=0;i--) {
			char caracter = Character.toUpperCase(cadena.charAt(i));
			lista.add(caracter);
		}
		for(int i = 0; i<cadena.length();i++) {
			char caracter = Character.toUpperCase(cadena.charAt(i));
			listaAux.add(caracter);
		}
		
		System.out.println(lista);
		System.out.println(listaAux);
		
		boolean ver = esCapicua(lista,listaAux);
		if(ver == true) {
			System.out.println("Es capicua");
		}
		else {
			System.out.println("No es capicua");
		}
		
	}
	
	static boolean esCapicua(LinkedList<Character> fraseOriginal, LinkedList<Character> fraseInvertida) {
		boolean capicua = true;
		for(int i = 0; i<fraseOriginal.size();i++) {
			if(!fraseOriginal.get(i).equals(fraseInvertida.get(i)) ) {
				capicua = false;
			}
		}
		return capicua;	
	}
	
}
