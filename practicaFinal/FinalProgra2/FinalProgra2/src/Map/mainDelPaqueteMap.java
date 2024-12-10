package Map;

import java.util.Scanner;

public class mainDelPaqueteMap {
	public static void main(String[] args) {
        // Crear un escaner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // crear un diccionario
        ArrayMap<String, Integer> diccionario = new ArrayMap<>();

        System.out.println("Introduce palabras (finaliza con '.'):");
        int colisiones = 0;
        while (true) {
        	
            String palabra = scanner.nextLine().trim();
            if (palabra.equals(".")) {
                break;
            }

            Integer contadorActual = diccionario.get(palabra);
            if (contadorActual == null) {
                contadorActual = 0; // Inicializar a 0 si es null
            }
            //punto B:
            if(contadorActual >=1) {
            	colisiones++;
            }
            
            diccionario.put(palabra, contadorActual + 1); // Incrementar el contador
            
            
        }

        // Mostrar las palabras y su cantidad de apariciones
        System.out.println("Palabras y su cantidad de apariciones:");
        for (Entry<String, Integer> entry : diccionario.entries()) {
            System.out.println("Palabra: " + entry.getKey() + ", Apariciones: " + entry.getValue());
            
        }
        System.out.println("Colisiones: " + colisiones);

        // Cerrar el escaner
        scanner.close();
    }
}