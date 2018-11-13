package fiuba.algo3.ejemplo1;

import java.util.Hashtable;
import edificios.Edificio;

public class ZonaDeJuego {
	
	int cantidadFilas;
	int cantidadColumnas;
	
	
	
	public void crearZonaDeJuego(Integer args[][], int filas, int columnas) {
		
		this.cantidadFilas = filas;
		this.cantidadColumnas = columnas;
		
		Celda celda = new Celda();
		
		Hashtable<Integer, Celda> mapaDeCeldas = new Hashtable<Integer, Celda>();
		
		for (int i=1; i <= cantidadFilas; i++) {
			
			for (int j=1; j <= cantidadColumnas; j++) {
	 
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
	
	
	
	public void colocarUnidad(int fila, int columna) {
		
		//delega a Celda
		
		
	}	
	
	
	
	public void colocarEdificio(Edificio edificio, int fila, int columna) {
		
		//delega a Celda
		
	}
	
	
	}
