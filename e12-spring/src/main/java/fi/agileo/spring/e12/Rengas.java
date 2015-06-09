package fi.agileo.spring.e12;

public class Rengas implements Jalka {
	
	int numero;	
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return "R"+numero;
	}
}
