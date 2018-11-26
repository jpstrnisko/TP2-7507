package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.IAtacante;


public class Arquero extends Unidad implements IAtacante {
	
	protected int danioAEdificios = 10;
	protected int danioAUnidades = 15;
	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.distanciaMaximaAtaque = 3;
	}

	public boolean estaEnRangoDeAtaqueEnX(Posicion posicion) {
		return this.posicion.obtenerPosicionX() + posicion.obtenerPosicionX() <= this.distanciaMaximaAtaque;
	}
	
	public boolean estaEnRangoDeAtaqueEnY(Posicion posicion) {
		return this.posicion.obtenerPosicionY() + posicion.obtenerPosicionY() <= this.distanciaMaximaAtaque;
	}	
	
	@Override
	public void atacar(Edificio edificio) {
		if(this.estaEnRangoDeAtaqueEnX(edificio.obtenerPosicion()) || this.estaEnRangoDeAtaqueEnY(edificio.obtenerPosicion()))
		edificio.quitarVida(this.danioAEdificios);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		if(this.estaEnRangoDeAtaqueEnX(unidad.obtenerPosicion()) || this.estaEnRangoDeAtaqueEnY(unidad.obtenerPosicion()))
		unidad.quitarVida(this.danioAUnidades);
	}
	
	
}
