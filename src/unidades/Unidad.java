package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import areaJuego.ZonaDeJuego;
import interfaces.Atacable;
import interfaces.TurnoMovimiento;
import turnos.TurnoMovimientoFinalizado;

public abstract class Unidad implements Atacable {
	
	protected int vida;
	protected int costo;
	protected int distanciaMaximaAtaque;
	protected TurnoMovimiento turnoMovimiento;
	protected Posicion posicion;

	public int obtenerVida() {
		return this.vida;
	}

	public int obtenerCosto() {
		return this.costo;
	}
	
	public void quitarVida(int danio) {
		this.vida -= danio;
	}
	
	public abstract void atacar(Atacable atacable);
	
	public void moverA(Posicion nuevaPosicion) {
		if(ZonaDeJuego.obtenerInstancia().esPosicionValida(nuevaPosicion))
			posicion = nuevaPosicion;
	}
	
	public void finalizarTurnoMovimiento() {
		this.turnoMovimiento = new TurnoMovimientoFinalizado();	
	}

	public boolean estaOcupando(Posicion posicion_) {
		return (posicion_.equals(this.posicion));
	}

	public void moverDerecha() {
		Posicion nuevaPosicion = this.posicion.obtenerNuevaPosicionVariando(0, 1);
		if(ZonaDeJuego.obtenerInstancia().estaDisponible(nuevaPosicion)) {
			this.posicion = nuevaPosicion;
		}
	}

	public Posicion obtenerPosicion() {
		return this.posicion;
	}
}
