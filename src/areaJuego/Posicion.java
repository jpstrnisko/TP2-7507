package areaJuego;
import java.awt.Point;

public class Posicion {
	
	protected Point coordenadas;
	
	public Posicion(int x, int y) {
		Point posicion = new Point(x, y);
		this.coordenadas = posicion;
	}
	
	public int obtenerPosicionX() {
		return (int)this.coordenadas.getX();
	}
	
	public int obtenerPosicionY() {
		return (int)this.coordenadas.getY();
	}
	
	public boolean posicionesSonIguales(Posicion pos2) {
		return (this.obtenerPosicionX() == pos2.obtenerPosicionX() && this.obtenerPosicionY() == pos2.obtenerPosicionY());
	}
	
	public Posicion obtenerNuevaPosicionVariadaEn(int x, int y) {
		return new Posicion(this.obtenerPosicionX() + x, this.obtenerPosicionY() + y);
	}
}
