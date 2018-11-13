package fiuba.algo3.ejemplo1;

public class ZonaDeJuego {
	
	int cantidadFilas;
	int cantidadColumnas;
	
	public void crearZonaDeJuego(int filas, int columnas) {
		
		cantidadFilas = filas;
		cantidadColumnas = columnas;
	}
	
	public boolean nollegoAlFinal(int fila, int columna) {
		
		return (fila > 1 && fila < cantidadFilas && columna > 1 && columna < cantidadColumnas);
	}
	
	public int obtenerTamanio() {
		
		return cantidadFilas*cantidadColumnas;
	}
}
