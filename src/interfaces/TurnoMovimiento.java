package interfaces;

import areaJuego.Posicion;
import unidades.Unidad;

public interface TurnoMovimiento {

	boolean moverUnidad(Posicion posicion) throws Exception;

}
