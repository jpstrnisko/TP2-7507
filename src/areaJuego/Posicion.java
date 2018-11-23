package areaJuego;

public class Posicion {
	
	protected int posX;
	protected int posY;
	
	public Posicion(int fila, int columna) {
		this.posX = fila;
		this.posY = columna;
	}
	
	public int obtenerPosicionX() {
		return this.posX;
	}
	
	public int obtenerPosicionY() {
		return this.posY;
	}
	
	public boolean posicionesSonIguales(Posicion pos2) {
		return (this.obtenerPosicionY()==pos2.obtenerPosicionY() && this.obtenerPosicionX()==pos2.obtenerPosicionX());
	}
}
