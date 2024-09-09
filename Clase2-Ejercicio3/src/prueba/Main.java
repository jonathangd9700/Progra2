package prueba;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Jugador jugador1 = new Jugador("Lionel Messi", 10, 4);
        Jugador jugador2 = new Jugador("Cristiano Ronaldo", 7, 4);
        Jugador jugador3 = new Jugador("Kylian Mbappe", 11, 4);
        Jugador jugador4 = new Jugador("Luka Modric", 10, 3); 
        Jugador jugador5 = new Jugador("Virgil van Dijk", 4, 2);
        Jugador jugador6 = new Jugador("Manuel Neuer", 1, 1); 
        Jugador jugador7 = new Jugador("Kevin De Bruyne", 17, 3); 
        Jugador jugador8 = new Jugador("Neymar Jr.", 10, 4); 
        Jugador jugador9 = new Jugador("Sergio Ramos", 4, 2); 
        Jugador jugador10 = new Jugador("Robert Lewandowski", 9, 4); 


        Equipo equipo1 = new Equipo("Barcelona", jugador1); 
        Equipo equipo2 = new Equipo("Real Madrid", jugador2); 


        jugador1.aumentarGoles(5);  
        jugador1.aumentarUnPartido(); 
        jugador2.aumentarGoles(7);  
        jugador2.aumentarUnPartido(); 
        jugador3.aumentarGoles(3);  
        jugador3.aumentarUnPartido(); 
        jugador4.aumentarGoles(2);  
        jugador4.aumentarUnPartido(); 
        jugador5.aumentarUnPartido(); 
        jugador6.aumentarUnPartido(); 
        jugador7.aumentarGoles(1); 
        jugador7.aumentarUnPartido();
        jugador8.aumentarGoles(4);
        jugador8.aumentarUnPartido();
        jugador9.aumentarUnPartido(); 
        jugador10.aumentarGoles(6);
        jugador10.aumentarUnPartido();


        equipo1.incrementarPG(true);
        equipo1.aumentarGfavor(5, 2);
        equipo1.aumentarGcontra(2);

        equipo2.incrementarPE(true);
        equipo2.aumentarGfavor(3, 1);
        equipo2.aumentarGcontra(3);

        // Mostrar información de equipos
        System.out.println("Puntos del equipo " + equipo1.getNombre() + ": " + equipo1.puntos());
        System.out.println("Puntos del equipo " + equipo2.getNombre() + ": " + equipo2.puntos());

        // Comparar cuál equipo tiene mayor puntaje
        Equipo equipoGanador = equipo1.mejorPuntaje(equipo2) ;
        System.out.println("Equipo con mayor puntaje: " + equipoGanador.getNombre());

        // Mostrar capitán con más goles
        Jugador capitanConMasGoles = equipo1.capitanConMasGoles(equipo2);
        System.out.println("El capitán con más goles es: " + capitanConMasGoles.aCadena());
		
	}

}
