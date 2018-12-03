package edificios;
import java.util.ArrayList;
import java.util.List;

import acciones.Construir;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.EstadoEdficio;
import interfaces.IAtacante;
import turnos.Jugador;
import unidades.Aldeano;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public abstract class Edificio implements Atacable{
	
	protected VidaEdificio vida;
	protected int costo;
	protected int tamanio;
	protected List<Posicion> posiciones = new ArrayList<Posicion>();
	protected Jugador jugador;
	protected int turnosConstruccion = 3;
	
	protected EstadoEdficio estadoEdificio = new EdificioEnConstruccion(turnosConstruccion);

	public int obtenerVida() {
		return vida.obtenerVida();
	}
	
	public int obtenerCosto() {
		return this.costo;
	}
	
	public boolean reparar() {
		return vida.reparar();
	}
	
	public void quitarVida(int danio) {
		vida.daniar(danio);
	}
	
	public int obtenerTamanio() {
		return this.tamanio;
	}
	
	public void establecerPosicion(Posicion posicion) {
		for(int i = 0; i < Math.sqrt(tamanio); i++) {
			for(int j = 0; j < Math.sqrt(tamanio); j++) {
				posiciones.add(posicion.obtenerNuevaPosicionVariadaEn(i, j));
			}
		}
	}
	
	public void cambiarJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public List<Posicion> obtenerPosiciones() {
		return this.posiciones;
	}
	
	public Posicion obtenerPosicionInicial() {
		return this.posiciones.get(0);
	}

	public Jugador obtenerJugador() {
		return jugador;
	}

	public void destruir() {
		
	}
	
	public boolean estaEnConstruccion() {
		return estadoEdificio.estaEnConstruccion();
	}
	
	public void finalizarConstruccion() {
		estadoEdificio = new EdificioConstruido();
	}
	
	public void continuarConstruccion(Aldeano aldeano) {
		estadoEdificio.continuarDesarrollo(this, aldeano);
	}

	public void aumentarVidaConstruccion() {
		vida.aumentarVidaConstruccion();
	}

	public int obtenerTurnosConstruccion() {
		return turnosConstruccion;
	}

	public void establecerVida(int valor) {
		vida.establecer(valor);
	}

	public void continuarReparacion(Aldeano aldeano) {
		estadoEdificio.continuarDesarrollo(this, aldeano);
	}

	public void comenzarReparacion() {
		estadoEdificio = new EdificioEnReparacion();
	}

	public boolean poseeVidaMaxima() {
		return vida.esMaxima();
	}
	
	public boolean estaEnRangoDe(int rango, IAtacante atacante) {
		for(Posicion posicion: this.obtenerPosiciones()) {
			if(posicion.estaEnRango(atacante.obtenerPosicion(), atacante.obtenerRangoAtaque()))
				return true;
		}
		return false;
	}
	
	public boolean estaOcupando(Posicion posicion) {
		return this.posiciones.contains(posicion);
	}

		
}
