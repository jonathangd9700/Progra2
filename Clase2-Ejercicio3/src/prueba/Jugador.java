package prueba;

public class Jugador {
	private String nombre;
	private int nroCamiseta;
	private int posicion;
	private int golesConvertidos;
	private int partidosJugados;
	
	public Jugador(String nom) {
		this.nombre = nom;
	}
	//COMANDOS
	public void aumentarGoles(int n){
		this.golesConvertidos++;
	}
	
	public void aumentarUnPartido() {
		this.partidosJugados++;
	}
	
	//CONSULTAS
	public int promedioGolesPart() {
		if(this.partidosJugados == 0) {
			return 0;
		}
		int promedioGoles = this.golesConvertidos / this.partidosJugados;
		return promedioGoles;
	}
	
	public Jugador jugConMasGoles(Jugador j) {
		if(this.golesConvertidos > j.golesConvertidos) {
			return this;
		}
		else {
			return j;
		}
	}
	
	public boolean masGoles(Jugador j) {
		if (this.golesConvertidos > j.golesConvertidos) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String aCadena() {
		System.out.println("Nombre: "+ this.nombre);
		System.out.println("N° Camiseta: "+ this.nroCamiseta);
		System.out.println("Posición: "+ this.posicion);
		System.out.println("Goles convertidos: "+this.golesConvertidos);
		System.out.println("Partidos jugados: "+this.partidosJugados);
	}
}
