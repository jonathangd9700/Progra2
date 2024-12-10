package abb;

import java.util.Comparator;

import Map.ArrayMap;
import Map.Entry;

public class mainPrueba {
    public static void main(String[] args) {
        // Crear un comparador para los elementos (en este caso, enteros)
        Comparator<Integer> comparator = Integer::compareTo;

        // Crear una instancia del árbol binario de búsqueda
        arbolBB<Integer> arbol = new arbolBB<>(comparator);

        // Insertar algunos elementos
        arbol.insertar(10);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(3);
        arbol.insertar(7);
        arbol.insertar(12);
        arbol.insertar(18);

        // Obtener el mapa con los elementos y la cantidad de hijos
        ArrayMap<Integer, Integer> map = arbol.toMap();

        // Imprimir el contenido del mapa
        for (Entry<Integer, Integer> entry : map.entries()) {
            System.out.println("Elemento: " + entry.getKey() + ", Cantidad de hijos: " + entry.getValue());
        }
    }
}