package ejercicio5;

public class TempMinEstacion {
	private float [] S;
	
	public TempMinEstacion(int cantElementos){
		S = new float[cantElementos];
	}
	public void agregarElemento(float temperatura, int posicion) {
		if(posicion>= S.length) {
			System.out.println("Esa posición no es posible agregar");
		}
		else {
			S[posicion] = temperatura;
		}
	}
	
	public void establecerTempMin(int i, float elemento) {
		
	}
	
	public int getLength() {
		return S.length;
	}
	public float[] getArray() {
		return S;
	}
	
	public float mayorTempMin() {
		float mayor = S[0];
		for(int i =1; i< S.length; i++) {
			if(mayor < S[i]) {
				mayor = S[i];
			}
		}
		return mayor;
	}

	public float promedioTempMin() {
		if(S.length == 0 ) {
			System.out.println("No hay temperaturas cargadas");
			return 0;
		}
		else if(sumaTemperaturas() == 0) {
			return 0;
		}
		else {
			return sumaTemperaturas()/S.length;
		}
	}
	private float sumaTemperaturas() {
		float suma = 0;
		for(int i = 0; i < S.length; i++) {
			suma += S[i];
		}
		return suma;
	}
	
	public int cantHeladas() {
		int contadorHeladas = 0;
		for (float i : S) {
			if (i < 0) {
				contadorHeladas++;
			}
		}
		return contadorHeladas;
	}
	
	public boolean huboHeladas() {
		if(cantHeladas()>0) {
			return true;
		}
		return false;
	}
	
	//Ejercicio 5
	public float menorTemperatura() {
		float menor = S[0];
		for(int i =0; i < S.length; i++) {
			if(S[i] < menor) {
				menor = S[i];
			}
		}
		return menor;
	};

	public int posMenor() {
		float menor = menorTemperatura();
		for (int i = 0; i < S.length;i++) {
			if (menor == S[i]) {
				return i;
			}
		}
		return -1;
	};
	
	
	public boolean todosPositivos() {
		for (int i = 0; i<S.length;i++) {
			if(S[i]<0) {
				return false;
			}
		}
		return true;
	};
	
	
	public int contarCoincidencias(TempMinEstacion s) {
		int contador = 0;
		float lista[];
		lista = s.getArray();
		for(int i = 0; i< S.length; i++) {
			if(S[i] == lista[i]) {
				contador ++;
			}
		}
		return contador;
	};
	public TempMinEstacion invertir() {
		TempMinEstacion listaInvertida = new TempMinEstacion(S.length);
		int posicion = 0;
		for(int i = S.length-1; i >= 0; i--) {
			listaInvertida.agregarElemento(this.S[i], posicion++);
		}
		listaInvertida.mostrarElementos();
		return listaInvertida;
		
	};
    public void mostrarElementos() {
        for (float temp : S) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }
	
	public void reemplazar(float val1,float val2) {
		for(int i= 0; i<S.length;i++) {
			if(S[i] == val1) {
				S[i] = val2;
			}
			else {
				System.out.println("Ese valor no se encuentra");
			}
		}
	}
	
	public String intercambiar(int pos1, int pos2) {
		if(S.length< pos1 || S.length<pos2) {
			return "Esa posición no existe";
		}
		else {
			float aux = S[pos1];
			S[pos1] = S[pos2];
			S[pos2] = aux;
			return "";
		}
	}
	/*
	public void invertirMe() {};
	public void ordenar() {};
		*/
}
