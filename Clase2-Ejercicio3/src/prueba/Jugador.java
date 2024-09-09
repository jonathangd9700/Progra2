package prueba;

public class Jugador {
	private String nombre;
	private int nroCamiseta;
	private int posicion;
	private int golesConvertidos;
	private int partidosJugados;
	
    public Jugador(String nombre, int nroCamiseta, int posicion) {
        this.nombre = nombre;
        this.nroCamiseta = nroCamiseta;
        this.posicion = posicion;
        this.golesConvertidos = 0;
        this.partidosJugados = 0; 
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
	    return "Nombre: " + this.nombre + "\n" +
	            "N° Camiseta: " + this.nroCamiseta + "\n" +
	            "Posición: " + this.posicion + "\n" +
	            "Goles convertidos: " + this.golesConvertidos + "\n" +
	            "Partidos jugados: " + this.partidosJugados;
	}
}
