package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.IAtacante;


public class Espadachin extends Unidad implements IAtacante {
	
	protected int danioAUnidades = 25;
	protected int danioAEdifcios = 15;
	
	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.distanciaMaximaAtaque = 1; //cuerpo a cuerpo
	}
	
	public boolean estaEnRangoDeAtaqueEnX(Posicion posicion) {
		return this.posicion.obtenerPosicionX() + posicion.obtenerPosicionX() <= this.distanciaMaximaAtaque;
	}
	
	public boolean estaEnRangoDeAtaqueEnY(Posicion posicion) {
		return this.posicion.obtenerPosicionY() + posicion.obtenerPosicionY() <= this.distanciaMaximaAtaque;
	}
	
	@Override
	public void atacar(Edificio edificio) {
		if (this.estaEnRangoDeAtaqueEnX(edificio.obtenerPosicion()) || this.estaEnRangoDeAtaqueEnY(edificio.obtenerPosicion()))
		edificio.quitarVida(this.danioAEdifcios);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		if(this.estaEnRangoDeAtaqueEnX(unidad.obtenerPosicion()) || this.estaEnRangoDeAtaqueEnY(unidad.obtenerPosicion()))
		unidad.quitarVida(this.danioAUnidades);
	}
	
	
}
