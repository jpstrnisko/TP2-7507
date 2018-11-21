package areaJuego;

import java.util.ArrayList;
import java.util.List;

import edificios.Edificio;
import unidades.Unidad;

public class ZonaDeJuego {
	
	private static ZonaDeJuego instanciaUnica = null; 
	protected int cantidadFilas = 50;
	protected int cantidadColumnas = 50;
	protected List<Unidad> unidades = new ArrayList<Unidad>();
	protected List<Edificio> edificios = new ArrayList<Edificio>();
	
	public static ZonaDeJuego obtenerInstancia() { 
		/*Utiliza patrón Singleton para tener solo una instancia disponible*/
        if (instanciaUnica == null) 
        	instanciaUnica = new ZonaDeJuego(); 
  
        return instanciaUnica; 
    }
	
	private ZonaDeJuego() {
		
	}
	
	public static ZonaDeJuego obtenerNuevaInstancia() {
		/*Entrega una instancia nueva de Zona de Juego para utilizar
		en pruebas unitarias*/
		
		instanciaUnica = new ZonaDeJuego();
		return instanciaUnica;
	}

	public void agregarUnidad(Unidad unidad) {
		unidades.add(unidad);
	}

	public List<Unidad> obtenerUnidades() {
		return unidades;
	}

	public int obtenerCantidadFilas() {
		return cantidadFilas;
	}

	public int obtenerCantidadColumnas() {
		return cantidadColumnas;
	}

	public void agregarEdificio(Edificio edificio) {
		edificios.add(edificio);
	}

	public List<Edificio> obtenerEdificios() {
		return edificios;
	}

	public boolean esPosicionValida(Posicion posicion) {
		return (posicion.obtenerPosicionFila() <= this.obtenerCantidadFilas() && posicion.obtenerPosicionColumna() <= this.obtenerCantidadColumnas());
	}

	public boolean estaDisponible(Posicion posicion) {
		for (int i = 0; i < unidades.size(); i++) {
			if(unidades.get(i).estaOcupando(posicion))
				return false;
		}
		for (int i = 0; i < edificios.size(); i++) {
			if(edificios.get(i).estaOcupando(posicion))
				return false;
		}
		return true;
	}

}
