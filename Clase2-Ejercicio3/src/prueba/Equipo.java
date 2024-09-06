package prueba;

public class Equipo {
	private String nombre;
	private Jugador capitan;
	private int pG, pE, pP;
	private int gFavor, gContra;
	private int puntos = 0;
	
	public Equipo(String nom, Jugador cap) {
		this.nombre = nom;
		this.capitan = cap;
	}
	
	//COMANDOS
	public void incrementarPG(boolean jugoElCap) {
		this.pG++;
		if (jugoElCap) {
			this.capitan.aumentarUnPartido();
		}
	}
	
	public void incrementarPE(boolean jugoElCap) {
		this.pE++;
		if (jugoElCap) {
			this.capitan.aumentarUnPartido();
		}
	}
	
	public void incrementarPP(boolean jugoElCap) {
		this.pP++;
		if (jugoElCap) {
			this.capitan.aumentarUnPartido();
		}
	}
	
	public void aumentarGfavor (int total, int delCap) {
		this.gFavor++;
		this.capitan.aumentarGoles(delCap);
	}
	
	public void aumentarGcontra(int total) {
		this.gContra++;
	}
	
	//CONSULTAS
	public int partidos() {
		return this.pG+this.pE+this.pP;
	}
	
	public int puntos() {
		return (this.puntos*3)+this.pE;
	}
	
	public Equipo mejorPuntaje(Equipos e) {
		
	}
	
	public Jugador capitanConMasGoles(Equipo e) {
		
	}
}
