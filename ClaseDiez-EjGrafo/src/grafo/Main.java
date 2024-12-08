package grafo;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		GrafoDin<String> grafoDinamico = new GrafoDin<>();
		grafoDinamico.agregarVertice("A");
		grafoDinamico.agregarVertice("B");
		grafoDinamico.agregarVertice("C");
		grafoDinamico.agregarVertice("J");
		grafoDinamico.agregarVertice("Y");
		grafoDinamico.agregarVertice("S");
		grafoDinamico.agregarVertice("R");
		grafoDinamico.agregarVertice("Q");
		grafoDinamico.agregarArista("A", "B", 10);
		grafoDinamico.agregarArista("B", "C", 5); //puente B de A -> C
		grafoDinamico.agregarArista("Y", "J", 3);
		grafoDinamico.agregarArista("S", "J", 3);
		grafoDinamico.agregarArista("R", "Q", 7);
		grafoDinamico.agregarArista("Q", "J", 11);
		grafoDinamico.agregarArista("A", "S", 0);
		grafoDinamico.agregarArista("S", "C", 0); //puente S de A -> C
		
		
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
		
		List<String> puentes = grafoDinamico.verticePuente("A", "C");
		
		System.out.println(puentes);
		*/
		
		///////////////////////////////
		//ESTATICO
		
		GrafoEst<String> grafoEstatico = new GrafoEst<String>(); //Podría ser de char jaja
		
		grafoEstatico.inicializarGrafo();
		
		grafoEstatico.agregarVertice("A");
		grafoEstatico.agregarVertice("B");
		grafoEstatico.agregarVertice("C");
		grafoEstatico.agregarVertice("J"); //Aislado
		grafoEstatico.agregarVertice("H"); //AISLADO
		grafoEstatico.agregarVertice("Y");
		grafoEstatico.agregarVertice("Z"); //Aislado
		grafoEstatico.agregarArista("A", "B", 10);
		grafoEstatico.agregarArista("B", "C", 5);
		grafoEstatico.agregarArista("C", "Y", 3);
		
		//VERTICES AISLADOS
		List<String> aislados = grafoEstatico.verticesAislados();
		
		
		System.out.println("Vertices Aislados: " + aislados);

	}

}
