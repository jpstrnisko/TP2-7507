package turnos;

import areaJuego.Mapa;
import areaJuego.Posicion;
import interfaces.TurnoMovimiento;
import juego.Juego;
import unidades.Espadachin;
import unidades.Unidad;

public class TurnoMovimientoHabilitado implements TurnoMovimiento{
	
	protected Unidad unidad;
	
	public TurnoMovimientoHabilitado(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public boolean moverUnidad(Posicion posicion) throws Exception {
		Mapa mapa = Juego.obtenerInstancia().obtenerMapa();
		if(unidad.obtenerPosicion().esAdyacente(posicion) && mapa.posicionEsValida(posicion)) {
			unidad.cambiarPosicion(posicion);
			mapa.removerAtacable(unidad);
			mapa.colocarAtacable(posicion, unidad);
			unidad.reiniciarAccion();
			unidad.finalizarTurnoMovimiento();
			return true;
		}
		return false;
	}

}
