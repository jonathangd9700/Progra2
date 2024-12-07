package grafo;

import java.util.ArrayList;
import java.util.List;

public class GrafoDin<E> implements GrafoTDA<E> {
	private NodoVertice<E> origen;
	private int vertices;
	
	public GrafoDin() {
		origen = null;
	}
	
	public void agregarVertice(E v) { //El vértice se inserta al inicio de la lista de nodos
		NodoVertice<E> aux = new NodoVertice<E>();
		aux.setVertice(v);
		aux.setAristas(null);
		aux.setSigVertice(origen);
		origen = aux;
		vertices++;
	}
	
	
	
	public void eliminarVertice(E v) {
		if (origen.getVertice().equals(v)) //Es el origen
			origen = origen.getSigVertice(); //Se elimina el origen
		NodoVertice<E> aux = origen; //No es el origen; hay que buscarlo
		while (aux != null) { //Eliminamos aristas hacia v
			this.eliminarAristaNodo(aux, v);
			if (aux.getSigVertice() != null && aux.getSigVertice().getVertice().equals(v)) {
				aux.setSigVertice(aux.getSigVertice().getSigVertice()); //Si es el nodo, lo elimina
				vertices--;
			}
			aux = aux.getSigVertice(); //Sigue eliminando aristas
		}
		
	}
	
	private void eliminarAristaNodo(NodoVertice<E> nodo, E v) {
		NodoArista<E> aux = nodo.getAristas(); //Elimina de nodo las aristas hacia v
		if (aux != null) {
			if (aux.getVerticeDestino().getVertice().equals(v)) { //Hay que eliminar la primera arista
				nodo.setAristas(aux.getSigArista());
			} 
			else { //No es la primera; la buscamos
				while (aux.getSigArista() != null && !aux.getSigArista().getVerticeDestino().getVertice().equals(v))
					aux = aux.getSigArista();
				if (aux.getSigArista() != null) { //Eliminamos la arista
					aux.setSigArista(aux.getSigArista().getSigArista());
				}
			}
		}
	}
	
	public E[] vertices() {
		E[] salida = (E[])new Object[vertices];
		NodoVertice<E> aux = origen;
		int i = 0;
		while (aux != null) {
			salida[i]=aux.getVertice();
			i++;
			aux = aux.getSigVertice();
		}
		return salida;
	}
	
	public void agregarArista(E v1, E v2, int peso ) {
		NodoVertice<E> n1 = vert2Nodo(v1); //Buscamos el nodo origen...
		NodoVertice<E> n2 = vert2Nodo(v2); //... y el nodo destino
		NodoArista<E> aux = new NodoArista<E>(); //La arista va al inicio de la lista...
		aux.setPeso(peso); //... de aristas salientes de v1
		aux.setVerticeDestino(n2);
		aux.setSigArista(n1.getAristas());
		n1.setAristas(aux);
	}
	
	private NodoVertice<E> vert2Nodo(E v) { //Dado un valor, busca el nodo correspondiente
		NodoVertice<E> aux = origen;
		while (aux != null && !aux.getVertice().equals(v))
			aux = aux.getSigVertice();
		return aux;
	}
	
	public void eliminarArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		eliminarAristaNodo(n1, v2);
	}
	
	public boolean existeArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (aux != null && !aux.getVerticeDestino().getVertice().equals(v2)) {
			aux = aux.getSigArista();
		}
		//Solo si se encontro la arista buscada, aux no es null
		return aux != null;
	}
	
	public int pesoArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (!aux.getVerticeDestino().getVertice().equals(v2))
			aux = aux.getSigArista(); //Buscamos la arista
		return aux.getPeso();
	}
	
	

	public List<E> obtenerVerticesAislados(){
		List<E> verticesAislados = new ArrayList<>();
		E[] vertices = vertices();

		for(int i = 0; i < vertices.length; i++) {
			boolean aristaEncontrada = false;
			for(int a = 1; a < vertices.length; a++){
				if(existeArista(vertices[i], vertices[a]) || existeArista(vertices[a], vertices[i])){
					aristaEncontrada = true;
					break;
				}
			}
			if(aristaEncontrada == false) {
				verticesAislados.add(vertices[i]);
			}
		}
		return verticesAislados;
	}
}

public List<E> obtenerVerticesAislados(){
	List<E> verticesAislados = new ArrayList<>();
	E[] vertices = vertices();

	for(int i = 0; i < vertices.length; i++) {
		boolean aristaEncontrada = false;
		for(int a = 1; a < vertices.length; a++){
			if(existeArista(vertices[i], vertices[a]) || existeArista(vertices[a], vertices[i])){
				aristaEncontrada = true;
				break;
			}
		}
		if(aristaEncontrada == false) {
			verticesAislados.add(vertices[i]);
		}
	}
	return verticesAislados;
}

public String verAux (E vert1) {
	NodoVertice<E> nodoVert1 = encontrarVertice(vert1);
	/*NodoVertice<E> verticeAux = origen;
	if(verticeAux.getVertice().equals(vert1)) {
		return "Hola";
	}*/
	return ""+nodoVert1.getSigVertice().getVertice()+"";
	
}

public List<E> verticePuente(E vert1, E vert2){
	List<E> lista = new ArrayList<E>();
	NodoVertice<E> nodoVert1 = encontrarVertice(vert1);
	NodoVertice<E> nodoVert2 = encontrarVertice(vert2);
	E aux;
	
	if(nodoVert1 != null && nodoVert2 !=null) {
		//Debería ver si existe una arista entre vert1 y vert 2 ya no hay puente. Si no existe, debería tomar el sigVertice del vertice1 y de ese asignale al aux; luego ver si existe arista entra el vert1 y el
		//verticeAux. Si existe, verifico si existe una arista del verticeAux al vert2.
		if(!existeArista(vert1,vert2)) {
			aux = nodoVert1.getSigVertice().getVertice();
			if(existeArista(vert1, aux) && existeArista(aux,vert2)) {
				lista.add(aux);
			}
		}
	}
	
	
	return lista;
}

private NodoVertice<E> encontrarVertice(E vertice){
	NodoVertice<E> auxiliar = origen;
	for(int i = 0; i < vertices().length; i++) {
		if(auxiliar.getVertice().equals(vertice)) {
			return auxiliar;
		}
		auxiliar = auxiliar.getSigVertice();
	}
	return null;
}

}

