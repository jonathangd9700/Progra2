package ejercicio4;

import stack.PilaEnlazada;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PilaEnlazada<LinkedQueue> p1 = new PilaEnlazada<LinkedQueue>();
		PilaEnlazada<LinkedQueue> p2 = new PilaEnlazada<LinkedQueue>();
		
		LinkedQueue<Integer> c1 = new LinkedQueue<Integer>();
		LinkedQueue<Integer> c2 = new LinkedQueue<Integer>();
		LinkedQueue<Integer> c3 = new LinkedQueue<Integer>();
		
		System.out.println("Cola 1");
		cargarColas(c1);
		System.out.println(c1);
		System.out.println("Cola 2");
		cargarColas(c2);
		System.out.println(c2);
		System.out.println("Cola 3");
		cargarColas(c3);
		System.out.println(c3);
		p1.push(c1);
		p1.push(c3);
		p2.push(c2);
		
		System.out.println("El tamaño de la pila 1 es:"+p1.size());
		System.out.println("El tamaño de la pila 2 es:"+p2.size());
		
		PilaEnlazada<LinkedQueue> pout= unirPilas(p1,p2);

		
		System.out.println(pout.top());
		
	}
	
	static void cargarColas(LinkedQueue cola) {
		int cantidad = (int)(Math.random()*10);
		if(cantidad == 0) {
			cantidad++;
		}
		for(int i = 0; i<cantidad;i++) {
			int numero = (int) (Math.random()*10);

			System.out.print(numero+"-");
			cola.enqueue(numero);
		}
		System.out.println();
	}
	
	static void ordenarPilas(PilaEnlazada<LinkedQueue> pila) {
		PilaEnlazada<LinkedQueue> pilaAux = new PilaEnlazada<LinkedQueue>();
		
        while (!pila.isEmpty()) {
            LinkedQueue temp = pila.pop();
            
            while (!pilaAux.isEmpty() && pilaAux.top().size() > temp.size()) {
                pila.push(pilaAux.pop());
            }
            pilaAux.push(temp);
        }
        while (!pilaAux.isEmpty()) {
            pila.push(pilaAux.pop());
	}
        }
	
	static PilaEnlazada<LinkedQueue> unirPilas(PilaEnlazada<LinkedQueue> p1, PilaEnlazada<LinkedQueue>p2){
		PilaEnlazada<LinkedQueue> pout = new PilaEnlazada<LinkedQueue>();
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("Largo de la cola top");
		System.out.println(p1.pop().size());
		System.out.println(p1.pop().size());
		/*
		si top de la pila 1 > top de la pila 2, put.push pila1.pop
		else
			pout.push pil2.pop
		*/
		/*
		todo esto mientras el size de la pila 1 > 0,
		
		if size pila 1 >0 || size pila 2 > 0{
			
		}
		*/
		
		while(p1.size() > 0 && p2.size()>0) {
			LinkedQueue<Integer> tailColaP1 = p1.top();
			LinkedQueue<Integer> tailColaP2 = p2.top();
			if(tailColaP1.size() >= tailColaP2.size()) {
				pout.push(p1.pop());
			}
			else {
				pout.push(p2.pop());
			}
		}
		
		if(!p1.isEmpty()) {
			while(p1.size()!=0) {
				pout.push(p1.pop());
			}
		}
		else if(!p2.isEmpty()) {
			while(p2.size()!=0) {
				pout.push(p2.pop());
			}
		}
		
		//ANTIGUO CÓDIGO
		/*
		if(p1.size()>=p2.size()) {
			while(p2.size()>0) {
				pout.push(p2.pop());
			}
			}
			else {
				while(p1.size()>0) {
					pout.push(p1.pop());
				}
			}
		
		if(p1.size()==0) {
			pout.push(p2.pop());
		}
		else {
			pout.push(p1.pop());
		}
		*/
		return pout;
	}

}
