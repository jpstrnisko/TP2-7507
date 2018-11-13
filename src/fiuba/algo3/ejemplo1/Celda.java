package fiuba.algo3.ejemplo1;


public class Celda {
	
	boolean libre = true;
	int fila;
	int columna;
		
	public boolean estaLibre() {
		
		return libre;		
	}
	
	
	public void colocarUnidad(int fil, int col) {
		
			fila = fil;
			columna = col;
			libre = false;
			
		}
		
				
	}
	
		
