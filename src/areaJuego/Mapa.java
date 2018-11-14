package areaJuego;

import edificios.Edificio;


public class Mapa {
	
	ZonaDeJuego zonaDeJuego = new ZonaDeJuego();
	Integer[][] tamanio;
		
	
	
	public void asignarTamanio(int filas,int columnas) {
		
		tamanio = new Integer[filas][columnas];
		
		zonaDeJuego.crearZonaDeJuego(tamanio,filas,columnas);
		
				
	}
	
	public int obtenerTamanio() {
		
		int tamanio = zonaDeJuego.obtenerTamanio();
		
		return tamanio;		
	}
	
	
	public void colocarAtacable(int fila, int columna) {
		
		zonaDeJuego.colocarAtacable(fila,columna);
			
	}	
	
		
	
		
	
			
}