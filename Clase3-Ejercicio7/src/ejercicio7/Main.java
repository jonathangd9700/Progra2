package ejercicio7;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ingrese una frase con paretensis");
		String frase = System.console().readLine();
		
		boolean resultado = parentesis(frase);
		
		if (resultado == true) {
			System.out.println("Parentesis equilibrados");
		}
		else {
			System.out.println("Parentesis desequilibrados");
		}
	}
	
	
	static boolean parentesis(String frase) {
		PilaEnlazada<Character> parentesisFrase = new PilaEnlazada<Character>();
		
		//Si el primer caracter que ingresa a la pila es una apertura de parentesis, hace push. Caso contrario de que sea un parentesis cerrado, retorna false ya que nunca será equilibrado ese ')'.
		//Cada vez que encuentra una apertura de parentesis hace push a la pila. Y cada vez que encuentra un cierre de parentesis hace un pop, por lo tanto si la cantidad de push que realiza es = a la cantidad de pop
		//la pila se mantiene vacia, eso quiere decir que las aperturas y cierres de parentesis está equilibrado.
		
		for(int i = 0; i<frase.length();i++)
		{
			if(frase.charAt(i) == '(') {
				parentesisFrase.push(frase.charAt(i));
			}
			else if(frase.charAt(i) == ')') {
				if(parentesisFrase.isEmpty()) {
					return false;
				}
				parentesisFrase.pop();
			}
		}	
		return true;

	}
}
