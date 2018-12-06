package edificios;

import java.util.List;

import areaJuego.Posicion;
import unidades.Unidad;

public class EdificioAtacante {
	
	protected int danioAEdificiosYUnidades;
	protected Edificio edificioPadre;
	protected int rangoAtaque;

	public EdificioAtacante(Castillo castillo, int danioAEdificiosYUnidades, int rango) {
		this.danioAEdificiosYUnidades = danioAEdificiosYUnidades;
		this.edificioPadre = castillo;
		this.rangoAtaque = rango;
	}

	private boolean estaEnRangoDeAtaqueEnX(Posicion posicion) {
		List<Posicion> posicionesEdificio = edificioPadre.obtenerPosiciones();
		for (int i = 0; i < posicionesEdificio.size(); i++) {
			if (Math.abs(posicionesEdificio.get(i).obtenerPosicionX() - posicion.obtenerPosicionX()) <= this.rangoAtaque) {
				return true;
			}
		}
		return false;
	}
	
	private boolean estaEnRangoDeAtaqueEnY(Posicion posicion) {
		List<Posicion> posicionesEdificio = edificioPadre.obtenerPosiciones();
		for (int i = 0; i < posicionesEdificio.size(); i++) {
			if (Math.abs(posicionesEdificio.get(i).obtenerPosicionY() - posicion.obtenerPosicionY()) <= this.rangoAtaque) {
				return true;
			}
		}
		return false;
	}
	
	public void atacar(Edificio edificio) {
		if(edificio.obtenerJugador() != edificioPadre.obtenerJugador()) {
			List<Posicion> posicionesEdificioObjetivo = edificio.obtenerPosiciones();
			for (int i = 0; i < posicionesEdificioObjetivo.size(); i++) {
				if(this.estaEnRangoDeAtaqueEnX(posicionesEdificioObjetivo.get(i)) && this.estaEnRangoDeAtaqueEnX(posicionesEdificioObjetivo.get(i))) {
					edificio.quitarVida(this.danioAEdificiosYUnidades);
					return;
				}
			}
		}
		
	}

	public void atacar(Unidad unidad) {
		if(this.estaEnRangoDeAtaqueEnX(unidad.obtenerPosicion()) && this.estaEnRangoDeAtaqueEnY(unidad.obtenerPosicion()) && unidad.obtenerJugador() != edificioPadre.obtenerJugador())
			unidad.quitarVida(this.danioAEdificiosYUnidades);
	}

}
