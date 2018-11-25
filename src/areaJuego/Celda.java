package areaJuego;
import interfaces.Atacable;


public class Celda {
	
	protected Posicion posicion;
	protected boolean libre = true;
	protected Atacable atacable = null;
	protected int fila;
	protected int columna;
	
	
	public Celda(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public Celda(int fil, int col) {
		fila = fil;
		columna = col;
	}
			
	public boolean estaLibre() {
		
		return this.libre;		
	}
	
	public void colocarAtacable(Atacable atacable, Posicion posicion) {
		
		if (this.estaLibre()){
			this.libre = false;
			this.atacable = atacable;
			this.posicion = posicion;
		}
	}
	
	public void posicionar() {
		if ( estaLibre()) {
			libre = false;
		}
	}
	
}
	

		
				

	
		
