package mapa;




public class Celda {
	
	boolean libre = true;
	int fila;
	int columna;
		
	
	
	public int obtenerCelda() {
		
		return fila+columna;
		
	}
	
	
	public boolean estaLibre() {
		
		return libre;		
	}
	
	
	public void colocarUnidad(int fil, int col) {
		
		if ( estaLibre()) {
			
			fila = fil;
			columna = col;
			libre = false;
			
		}
	}	
	
	public void colocarEdificio(int fil, int col) {
		
		
		
	}
		
				
	}
	
		
