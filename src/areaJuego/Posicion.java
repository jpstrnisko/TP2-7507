package areaJuego;

public class Posicion {
	
	protected int posX;
	protected int posY;
	
	public Posicion(int fila, int columna) {
		this.posX = fila;
		this.posY = columna;
	}
	
	public int obtenerPosicionFila() {
		return this.posX;
	}
	
	public int obtenerPosicionColumna() {
		return this.posY;
	}

}