package interfaces;

import areaJuego.Posicion;
import unidades.Unidad;

public interface TurnoMovimiento {
	
	public boolean moverUnidad(Posicion posicion, Unidad unidad);
}