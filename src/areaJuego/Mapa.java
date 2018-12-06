package areaJuego;

import edificios.Edificio;
import interfaces.Atacable;
import unidades.Unidad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class Mapa {
	
	protected int alto;
	protected int ancho;
	protected HashMap<Celda, Atacable> zonaDeJuego;
			
	public Mapa(int ancho, int alto) {
		this.alto = alto;
		this.ancho = ancho;
		this.zonaDeJuego = new HashMap<Celda, Atacable>();
	}
	
	
	public int obtenerAlto() {
		return this.alto;
	}
	
	public int obtenerAncho() {
		return this.ancho;
	}
	
	public int obtenerTamanio() {
		return this.alto * this.ancho;
	}
	
	public HashMap<Celda, Atacable> obtenerZonaDeJuego() {
		return this.zonaDeJuego;
	}
	
	
	public boolean seSalioDelMapa(Posicion posicion) {
		
		boolean salioEnAncho = Math.abs(posicion.obtenerPosicionX()) > this.ancho;
		boolean salioEnAlto = Math.abs(posicion.obtenerPosicionY()) > this.alto;
		return salioEnAncho || salioEnAlto;
	}
	
	public boolean posicionEstaOcupada(Posicion posicion) {
		for(Celda cadaCelda: this.zonaDeJuego.keySet()) {
			if (cadaCelda.obtenerPosicion().equals(posicion))
				return true;
		}
		return false;
	}
	
	public boolean atacableColisiona(Posicion posicion, int tamanioDeAtacable) {
		
		int posX = posicion.obtenerPosicionX();
		int posY = posicion.obtenerPosicionY();
		for(int i = 0; i < Math.sqrt(tamanioDeAtacable); i++) {
			for(int j = 0; j < Math.sqrt(tamanioDeAtacable); j++) {
					if(posicionEstaOcupada(new Posicion(posX + i, posY + j)))
						return true;
			}
		}
		return false;
	}

	public void colocarAtacable(Posicion posicion, Atacable atacable) throws Exception { 
		
		int tamanio = atacable.obtenerTamanio();
		int posX = posicion.obtenerPosicionX();
		int posY = posicion.obtenerPosicionY();
		for(int i=0; i < Math.sqrt(tamanio); i++) {
			for(int j=0; j < Math.sqrt(tamanio); j++) {
				Posicion posicionNueva = new Posicion(posX+i, posY+j);
				if(this.seSalioDelMapa(posicionNueva)) throw new PosicionFueraDeMapaError();
				if(this.posicionEstaOcupada(posicionNueva)) throw new PosicionOcupadaError();
				Celda celdaAGuardar = new Celda(posicionNueva);
				this.zonaDeJuego.put(celdaAGuardar, atacable);
			}
		}
	}
	
   public List<Unidad> obtenerUnidades() {
		List<Unidad> unidades = new ArrayList<Unidad>();
		for(Celda cadaCelda: this.zonaDeJuego.keySet()) {
			if (this.zonaDeJuego.get(cadaCelda) instanceof Unidad)
				unidades.add((Unidad) zonaDeJuego.get(cadaCelda));
		}
		return unidades;
	}


	public List<Edificio> obtenerEdificios() {
		List<Edificio> edificios = new ArrayList<Edificio>();
		for(Celda cadaCelda: this.zonaDeJuego.keySet()) {
			Atacable atacable = this.zonaDeJuego.get(cadaCelda);
			if (atacable instanceof Edificio && !edificios.contains(atacable))
				edificios.add((Edificio) zonaDeJuego.get(cadaCelda));
		}
		return edificios;
	}


	public void removerAtacable(Atacable atacable){
		List<Celda> celdasAEliminar = new ArrayList<Celda>();
		for(Celda cadaCelda: this.zonaDeJuego.keySet()) {
			if (this.zonaDeJuego.get(cadaCelda) == atacable)
				celdasAEliminar.add(cadaCelda);
		}
		for(Celda celda: celdasAEliminar) {
			this.zonaDeJuego.remove(celda);
		}
	}


	public boolean posicionEsValida(Posicion posicion) {
		return !(this.posicionEstaOcupada(posicion) || this.seSalioDelMapa(posicion));
	}


	public Atacable obtenerAtacableEn(Posicion posicion) {
		for(Celda cadaCelda: this.zonaDeJuego.keySet()) {
			if (this.zonaDeJuego.get(cadaCelda).estaOcupando(posicion))
				return this.zonaDeJuego.get(cadaCelda);
		}
		return null;
	}

}
		
	
	
			
	
