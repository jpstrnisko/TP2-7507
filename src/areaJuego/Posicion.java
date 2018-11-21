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

	public Posicion obtenerNuevaPosicionVariando(int i, int j) {
		return new Posicion(this.posX + i, this.posY + j);
	}
	
	public boolean equals(Posicion otraPosicion) {
		return (otraPosicion.obtenerPosicionColumna() == this.obtenerPosicionColumna() && otraPosicion.obtenerPosicionFila() == this.obtenerPosicionFila());
	}

}
