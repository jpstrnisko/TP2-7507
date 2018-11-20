package areaJuego;
import interfaces.Atacable;


public class Celda {
	
	protected Posicion posicion;
	protected boolean libre;
	protected Atacable atacable;
	
	
	public Celda(Posicion posicion) {
		this.posicion = posicion;
		this.atacable = null;
		this.libre = true;
	}
				
	public boolean estaLibre() {
		return this.libre;		
	}
	
	public void colocarAtacable(Atacable atacable, Posicion posicion) {
		this.atacable = atacable;
		this.posicion = posicion;
		this.libre = false;
	}
	
	public Posicion obtenerPosicion() {
		return this.posicion;
	}
	
}
	

		
				

	
		
