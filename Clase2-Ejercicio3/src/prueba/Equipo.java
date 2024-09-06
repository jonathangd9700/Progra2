package prueba;

public class Equipo {
	private String nombre;
	private Jugador capitan;
	private int pG, pE, pP;
	private int gFavor, gContra;
	
	public Equipo(String nom, Jugador cap) {
		this.nombre = nom;
		this.capitan = cap;
	}
	
	//COMANDOS
	public void incrementarPG(boolean jugoElCap) {
		
	}
	
	public void incrementarPE(boolean jugoElCap) {
		
	}
	
	public void incrementarPP(boolean jugoElCap) {
		
	}
	
	public void aumentarGfavor (int total, int delCap) {
		
	}
	
	public void aumentarGcontra(int total) {
		
	}
	
	//CONSULTAS
	public int partidos() {
		
	}
	
	public int puntos() {
		
	}
	
	public Equipo mejorPuntaje(Equipos e) {
		
	}
	
	public Jugador capitanConMasGoles(Equipo e) {
		
	}
}
