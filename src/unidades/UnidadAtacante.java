package unidades;

import java.util.List;

import areaJuego.Posicion;
import edificios.Edificio;

public class UnidadAtacante {
	
	protected int danioAEdificios;
	protected int danioAUnidades;
	protected Unidad unidadMadre;
	protected int rangoAtaque;
	
	public UnidadAtacante(Unidad unidad, int danioAEdificios, int danioAUnidades, int rangoAtaque) {
		this.danioAEdificios = danioAEdificios;
		this.danioAUnidades = danioAUnidades;
		this.unidadMadre = unidad;
		this.rangoAtaque = rangoAtaque;
	}
	
	private boolean estaEnRangoDeAtaqueEnX(Posicion posicion) {
		return Math.abs(this.unidadMadre.obtenerPosicion().obtenerPosicionX() - posicion.obtenerPosicionX()) <= this.rangoAtaque;
	}
	
	private boolean estaEnRangoDeAtaqueEnY(Posicion posicion) {
		return Math.abs(this.unidadMadre.obtenerPosicion().obtenerPosicionY() - posicion.obtenerPosicionY()) <= this.rangoAtaque;
	}	

	public void atacar(Edificio edificio) {
		List<Posicion> posicionesEdificio = edificio.obtenerPosiciones();
		for (int i = 0; i < posicionesEdificio.size(); i++) {
			if(this.estaEnRangoDeAtaqueEnX(posicionesEdificio.get(i)) && this.estaEnRangoDeAtaqueEnY(posicionesEdificio.get(i))) {
				edificio.quitarVida(this.danioAEdificios);
				return;
			}
		}
	}

	public void atacar(Unidad unidad) {
		if(this.estaEnRangoDeAtaqueEnX(unidad.obtenerPosicion()) && this.estaEnRangoDeAtaqueEnY(unidad.obtenerPosicion()))
			unidad.quitarVida(this.danioAUnidades);
	}

}
