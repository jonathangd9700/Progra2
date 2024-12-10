package parcial;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySet<Integer> set = new ArraySet<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		ArraySet<Integer> set2 = new ArraySet<Integer>();
		LinkedList<Integer> inter = new LinkedList<Integer>();
		LinkedList<Integer> uni = new LinkedList<Integer>();
		//Set 1
		set.insertar(4); //inter
		set.insertar(5);
		set.insertar(70); //inter
		set.insertar(-10);
		set.insertar(16);//inter
		set.insertar(27);
		set.insertar(24);//inter
		set.insertar(48);
		
		//list = set.values(); Con todos los valores
		
		//list.string();
		
		//set.delete(5);
		//list = set.values(); //Sin el 5
		//list.string()
		
		
		//Set 2
		set2.insertar(4);
		set2.insertar(51);
		set2.insertar(70);
		set2.insertar(-100);
		set2.insertar(16);
		set2.insertar(274);
		set2.insertar(24);
		set2.insertar(487);
		
		Set<Integer> interseccion = set.intersection(set2);
		Set<Integer> union = set.union(set2);
		inter = interseccion.values();

		inter.string();
		
		System.out.println("");
		uni = union.values();
		uni.string();
		
///////////////////
		ArraySet<String> A = new ArraySet<String>();
		ArraySet<String> B = new ArraySet<String>();
		/*
		System.out.println("Ingrese para el cojunto A");
		ingresarInputs(A);
		System.out.println("Ingrese para el cojunto B");
		ingresarInputs(B);
		*/
		String cadena = System.console().readLine("Ingresa: ");
		
		boolean valor = validarHTML(cadena);
		System.out.println(valor);
		
	}
	
	public static void ingresarInputs(ArraySet<String> set) {
		int i = 0;
		while(i < 3) {
			String valores = System.console().readLine("Ingrese un valor para el conjunto");
			if(validarHTML(valores)) {
				set.insertar(valores);
				i++;
			}
			else{
				System.out.println("Valor HTML invalido");
			};
			
		}
		
		
	}
	/*
	public static boolean validarHTML(String s) {
		char[] chars = s.toCharArray();
		ArrayStack<Character> pila = new ArrayStack<Character>();
		if(chars[0]!='<')
			return false;
		else
		{
			//Apilamos si es <
			//desapilamos si es >
			//avanzamos en cualquier caso
			//si llegué al final y la pila está vacía, true, sino false
			for(int i = 0; i<chars.length; i++) {
				if(chars[i]=='<')
					pila.push(chars[i]);
				if(chars[i]=='>')
					pila.pop();
			}
			return pila.isEmpty();
		
		}
	}
	*/
	public static boolean validarHTML(String input) {
		ArrayStack<Character> pila = new ArrayStack<Character>();
		char[] charact = input.toCharArray();
		if(charact[0] != '<') {
			return false;
		}
		int i = 0;
		while(charact[i] == '<') {
			pila.push(charact[i]);
			i++;
		}
		if(charact[input.length()-1] != '>') {
			return false;
		}
		int a = input.length()-1;
		while(charact[a] == '>' && !pila.isEmpty()) {
			pila.pop();
			a--;
		}/*
		for(int i = 0; i < input.length();i++) {
			if(charact[i] == '<'){
				pila.push(charact[i]);
			}
			else {
				if(charact[i] == '>') {
					pila.pop();
				}
			}
		}*/
		return pila.isEmpty();
		
	}
}
	

