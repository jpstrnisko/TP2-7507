package areaJuego;


public class Celda {
	
	protected Posicion posicion;
	protected boolean libre;	
	
	public Celda(Posicion posicion) {
		this.posicion = posicion;
		this.libre = true;
	}
				
	public boolean estaLibre() {
		return this.libre;		
	}
	
	public Posicion obtenerPosicion() {
		return this.posicion;
	}
	
	public void ocuparCelda() {
		this.libre = false;
	}
	
	public void desocuparCelda() {
		this.libre = true;
	}
	
}
	

		
				

	
		
