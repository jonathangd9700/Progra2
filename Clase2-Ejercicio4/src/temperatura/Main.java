package temperatura;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TempMinEstacion temperatura = new TempMinEstacion(5);
		float[] array = temperatura.getArray();
		
		temperatura.agregarElemento(8.5f, 0);
		temperatura.agregarElemento(0.4f, 1);
		temperatura.agregarElemento(12f, 2);
		temperatura.agregarElemento(4.4f, 3);
		temperatura.agregarElemento(3.1f, 4);

		
		for(int i = 0; i < temperatura.getLength();i++) {
			System.out.println(array[i]);
		}
	float mayor = temperatura.mayorTempMin();
	System.out.println("La mayor temperatura registrada fue: "+mayor);
	
	float promTemp = temperatura.promedioTempMin();
	int cantidadHeladas = temperatura.cantHeladas();
	boolean heladas = temperatura.huboHeladas();
	System.out.println("El promedio de las temperaturas registradas es: "+promTemp);
	System.out.println("Hubo " + cantidadHeladas + " heladas");
	System.out.println("Hubo heladas? "+ heladas);
	
	}
}
