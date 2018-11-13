package fiuba.algo3.ejemplo1;

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
	
	
	public void colocarUnidad(int fila, int columna) {
		
		zonaDeJuego.colocarUnidad(fila,columna);
			
	}	
	
	public void colocarEdificio (Edificio edificio, int fila, int columna) {
		
		zonaDeJuego.colocarEdificio(edificio,fila,columna);
	}	
		
	
		
	
			
}