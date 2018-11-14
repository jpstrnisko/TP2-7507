package fiuba.algo3.ejemplo1;

public class Celda {
	
	boolean libre; 
	int fila;
	int columna;
	
	
	public Celda(int fil, int col) {
		
		fila = fil;
		columna = col;
		libre = true;
		
	}
		
	
	public boolean estaLibre() {
		
		return libre;		
	}
	
		
	public void posicionar() {
		
		if ( estaLibre()) {
			
			libre = false;
		}
	}	
	
}
	
		
