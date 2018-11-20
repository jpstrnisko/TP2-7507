package areaJuego;

import edificios.Edificio;
import interfaces.Atacable;

import java.util.ArrayList;


public class Mapa {
	
	protected int alto;
	protected int ancho;
	protected ArrayList<Celda> celdas = new ArrayList();
			
	public Mapa(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
	}
	
	public void instalarCeldas() {
		for(int i = 0; i<this.ancho; i++) {
			for(int j = 0; j<this.alto; j++) {
				Celda celda = new Celda(new Posicion(i,j));
				this.celdas.add(celda);
			}
		}
	}
	
	public int obtenerAlto() {
		return this.alto;
	}
	
	public int obtenerAncho() {
		return this.ancho;
	}
	
	public int obtenerCantidadCeldas() {
		return celdas.size();
	}
	
	public boolean celdaOcupada(Posicion posicion) {
		Celda celda = null;
		for(Celda cadaCelda: celdas) {
			if(cadaCelda.obtenerPosicion().posicionesSonIguales(posicion))
				celda = cadaCelda;
		}
		return celda.estaLibre();
	}
	
	public ArrayList obtenerCeldas() {
		return celdas;
	}
	
	public void colocarAtacable(Posicion posicion, Atacable atacable) { //Por ahora solo para unidades (ocupan 1 solo casillero)
		Celda celda = null;
		for(Celda cadaCelda: celdas) {
			if (cadaCelda.obtenerPosicion().posicionesSonIguales(posicion))
				celda = cadaCelda;
		}
		celda.colocarAtacable(atacable, posicion);
	}
}
	
			
	
