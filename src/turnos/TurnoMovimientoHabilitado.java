package turnos;

import areaJuego.Posicion;
import interfaces.TurnoMovimiento;
import unidades.Unidad;

public class TurnoMovimientoHabilitado implements TurnoMovimiento{

	@Override
	public boolean moverUnidad(Posicion posicion, Unidad unidad) {
		//Falta codear la logica
		unidad.finalizarTurnoMovimiento();
		return true;
	}

}
