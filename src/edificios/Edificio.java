package edificios;
import java.util.ArrayList;
import java.util.List;

import areaJuego.Posicion;
import interfaces.Atacable;
import turnos.Jugador;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public abstract class Edificio implements Atacable{
	
	protected VidaEdificio vida;
	protected int costo;
	protected int tamanio;
	protected List<Posicion> posiciones = new ArrayList<Posicion>();
	protected Jugador jugador;

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
		
}
