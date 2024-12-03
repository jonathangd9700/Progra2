package grafo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoEst<Integer> grafoEstatico = new GrafoEst<Integer>();
		
		GrafoDin<String> grafoDinamico = new GrafoDin<>();
		grafoDinamico.agregarVertice("A");
		grafoDinamico.agregarVertice("B");
		grafoDinamico.agregarVertice("C");
		grafoDinamico.agregarVertice("J");
		grafoDinamico.agregarArista("A", "B", 10);
		grafoDinamico.agregarArista("B", "C", 5);
		
		Object[] vertices = grafoDinamico.vertices();
		
		String[] verticesStr = new String[vertices.length];
		
		for(int i = 0; i < vertices.length; i ++) {
			verticesStr[i] = (String) vertices[i];
		}
		
		//vertices = grafoDinamico.vertices();
		
		for(int i = 0; i < vertices.length; i++) {
			System.out.println(verticesStr[i]);
		}
		
		List<String> verticesAislados = grafoDinamico.obtenerVerticesAislados();
		System.out.println("Vértices aislados: " + verticesAislados);
		
		int peso = grafoDinamico.pesoArista("B", "C");
		System.out.println(peso);
		
	
		
	}

}
