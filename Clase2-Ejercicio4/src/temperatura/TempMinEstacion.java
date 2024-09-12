package temperatura;

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
		
}
	
	

	/*
	public float primeroMayor(float t) {
		
	}
	
	public boolean ordenadoCreciente() {
		
	}*/

