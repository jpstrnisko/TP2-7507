package areaJuego;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public boolean equals(Object pos2) {
		return (this.obtenerPosicionX() == ((Posicion) pos2).obtenerPosicionX() && this.obtenerPosicionY() == ((Posicion) pos2).obtenerPosicionY());
	}
	
	public Posicion obtenerNuevaPosicionVariadaEn(int x, int y) {
		return new Posicion(this.obtenerPosicionX() + x, this.obtenerPosicionY() + y);
	}

	public List<Posicion> obtenerPosicionesDeConstruccion(int tamanioEdificio) {
		List<Posicion> posicionesPosibles = new ArrayList<Posicion>();
		int xInicial = (int) (this.obtenerPosicionX() - Math.sqrt(tamanioEdificio));
		int yInicial = (int) (this.obtenerPosicionY() - Math.sqrt(tamanioEdificio));
		int xFinal = this.obtenerPosicionX() + 1;
		int yFinal = this.obtenerPosicionY() + 1;
		for(int x = xInicial; x <= xFinal; x++) {
			for(int y = yInicial; y <= yFinal; y++) {
				posicionesPosibles.add(new Posicion(x, y));
			}
		}
		xInicial++;
		yInicial++;
		xFinal = this.obtenerPosicionX();
		yFinal = this.obtenerPosicionY();
		for(int x = xInicial; x <= xFinal; x++) {
			for(int y = yInicial; y <= yFinal; y++) {
				posicionesPosibles.remove(new Posicion(x, y));
			}
		}
		return posicionesPosibles;
	}

	public boolean esAdyacente(Posicion posicion) {
		return this.estaEnRango(posicion, 1);
	}
	
	public boolean estaEnRango(Posicion posicion, int rango) {
		return (Math.abs(this.obtenerPosicionX() - posicion.obtenerPosicionX()) <= rango && Math.abs(this.obtenerPosicionY() - posicion.obtenerPosicionY()) <= rango);
	}
}
