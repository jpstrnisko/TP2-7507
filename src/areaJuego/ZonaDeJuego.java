package areaJuego;

import java.util.Hashtable;
import edificios.Edificio;

public class ZonaDeJuego {
	
	int cantidadFilas;
	int cantidadColumnas;
	
	
	
	public void crearZonaDeJuego(Integer args[][], int filas, int columnas) {
		
		this.cantidadFilas = filas;
		this.cantidadColumnas = columnas;
		
		
		
		Hashtable<Integer, Celda> mapaDeCeldas = new Hashtable<Integer, Celda>();
		
		for (int i=1; i <= cantidadFilas; i++) {
			
			for (int j=1; j <= cantidadColumnas; j++) {
				
				Celda celda = new Celda(new Posicion(i,j));
				mapaDeCeldas.put(i+j, celda);
			}
		}
	}
	
	
	public int obtenerTamanio() {
		
		return cantidadFilas*cantidadColumnas;
	}
	
	
	
	public boolean nollegoAlFinal(int fila, int columna) {
		
		return (fila >= 1 && fila <= cantidadFilas && columna >= 1 && columna <= cantidadColumnas);
	}
		
	
	
	public boolean espacioNoLLegoAlFinal(int cantidadCeldasAExplorar, int fila, int columna) {
		
		boolean espacioDesocupado = true;
		
		return espacioDesocupado;
	}	
	
	
	
	public void colocarAtacable(int fila, int columna) {
		
		//delega a Celda
		
		
	}	
	
	
	
}
