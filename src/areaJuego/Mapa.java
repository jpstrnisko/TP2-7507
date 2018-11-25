package areaJuego;

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
			
	public void posicionarEdificio(Edificio edificio, int fila, int columna, int opcion) {
		switch (opcion) {
		case 1: zonaDeJuego.posicionarEdificioIzquierdaArriba(fila,columna,edificio.celdasAOcupar());
		case 2: zonaDeJuego.posicionarEdificioDerechaArriba(fila,columna,edificio.celdasAOcupar());
		case 3: zonaDeJuego.posicionarEdificioIzquierdaAbajo(fila,columna,edificio.celdasAOcupar());
		case 4: zonaDeJuego.posicionarEdificioDerechaAbajo(fila,columna,edificio.celdasAOcupar());
		}
	}
	
	public void colocarAtacable(int fila, int columna) {
		zonaDeJuego.colocarAtacable(fila,columna);
	}	
	
}		
	
