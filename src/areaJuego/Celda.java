package areaJuego;
import interfaces.Atacable;


public class Celda {
	
	protected Posicion posicion;
	protected boolean libre = true;
	protected Atacable atacable = null;
	
	public Celda(Posicion posicion) {
		this.posicion = posicion;
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
}
	

		
				

	
		
