package fiuba.algo3.ejemplo1;

import edificios.Edificio;



public class Mapa {
	
	ZonaDeJuego zonaDeJuego = new ZonaDeJuego();
	
	
		
		
	public void asignarTamanio(int filas,int columnas) {
		
		zonaDeJuego.crearZonaDeJuego(filas,columnas);
		
				
	}
	
	
	
	public int obtenerTamanio() {
		
		int tamanio = zonaDeJuego.obtenerTamanio();
		
		return tamanio;		
	}
	
	
	public boolean estaLibre(int fila, int columna) {
		
		return zonaDeJuego.estaLibre(fila, columna);
	}
	
	public void posicionar(int fila, int columna) {
		
		zonaDeJuego.posicionar(fila,columna);
			
	}	
	
		
		
	public void posicionarEdificio(Edificio edificio, int fila, int columna) {
		
		edificio.obtenerTamanio();
		
		zonaDeJuego.posicionarEdificioIzquierdaArriba(fila, columna);
		
	}
		
	
			
}