package capicua;
public class Main {

    public static void main(String[] args) {
        String frase = System.console().readLine();
        if (esCapicua(frase)) {
            System.out.println("La frase es capicúa.");
        } else {
            System.out.println("La frase no es capicúa.");
        }
    }

    static boolean esCapicua(String frase) {
        // Creación de las pilas
        PilaEnlazada<Character> pilaCaracteres = new PilaEnlazada<Character>();
        PilaEnlazada<Character> pilaAux = new PilaEnlazada<Character>();
        PilaEnlazada<Character> pilaTemporal = new PilaEnlazada<Character>();

        frase = frase.replace(" ", "").toUpperCase();

        for (int i = 0; i < frase.length(); i++) {
            pilaCaracteres.push(frase.charAt(i));
        }

        while (pilaCaracteres.size() > 0) {
        	//Guardo el return del pop en "el" para poder asignarlo en ambas pilas
        	Character el = pilaCaracteres.pop();
            pilaAux.push(el);
            pilaTemporal.push(el);
        }
        
        //Uso la pila tempora para devolver el orden original a pilaCaracteres
        while(pilaTemporal.size()>0) {
        	pilaCaracteres.push(pilaTemporal.pop());
        }

        
        while (pilaAux.size()>0) {
            if (!pilaAux.pop().equals(pilaCaracteres.pop())) {
                return false;
            }
        }

        return true;
    }
}
