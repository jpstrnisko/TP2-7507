package turnos;

import areaJuego.Posicion;
import interfaces.TurnoMovimiento;
import unidades.Unidad;

public class TurnoMovimientoFinalizado implements TurnoMovimiento{

	@Override
	public boolean moverUnidad(Posicion posicion) {
		return false;
	}

}
