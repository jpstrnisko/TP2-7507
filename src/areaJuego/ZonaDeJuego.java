package areaJuego;


public class ZonaDeJuego {
	
	protected int cantidadFilas;
	protected int cantidadColumnas;
	Celda celdas[][];
	
	
	
	public void crearZonaDeJuego(int filas, int columnas) {
		this.cantidadFilas = filas;
		this.cantidadColumnas = columnas;
		celdas = new Celda[filas][columnas];
		
		for (int i= 0; i<filas; i++ ) {
			for (int j=0; j<columnas; j++) {
				celdas[i][j] = new Celda(i,j);
			}
		}
	}
	
	public int obtenerTamanio() {
		return cantidadFilas*cantidadColumnas;
	}
		
	public boolean nollegoAlFinal(int fila, int columna) {
		return (fila >= 1 && fila <= cantidadFilas && columna >= 1 && columna <= cantidadColumnas);
	}
		
	public boolean estaLibre(int fila, int columna) {
		return celdas[fila][columna].estaLibre();
	}
		
			
	public void posicionar(int fila, int columna) {
		celdas[fila][columna].posicionar();
		
	}
	
		
	
	public void posicionarEdificioIzquierdaArriba(int fila, int columna) {
		
		for (int i= fila-1; i<= fila; i++) {
			for (int j= columna-1; j<= columna; j++) {
				celdas[i][j].posicionar();	
		
			}			
		}

	}
	
	
	public void posicionarEdificioDerechaArriba(int fila, int columna) {
		
		for (int i= fila-1; i<= fila; i++) {
			for (int j= columna; j<= columna+1; j++) {
				celdas[i][j].posicionar();	
			}			
		}

	}
	
	
	public void posicionarEdificioIzquierdaAbajo(int fila, int columna) {
		
		for (int i= fila; i<= fila+1; i++) {
			for (int j= columna-1; j<= columna; j++) {
				celdas[i][j].posicionar();	
			}			
		}

	}
	
	
	public void posicionarEdificioDerechaAbajo(int fila, int columna) {
		
		for (int i= fila; i<= fila+1; i++) {
			for (int j= columna; j<= columna+1; j++) {
				celdas[i][j].posicionar();	
			}			
		}
	}
	
	public void colocarAtacable(int fila, int columna) {
		
		//delega a Celda
	}	
	
}
