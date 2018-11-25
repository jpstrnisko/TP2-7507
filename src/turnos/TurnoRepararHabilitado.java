package turnos;

import edificios.Edificio;
import interfaces.TurnoReparar;
import unidades.Aldeano;

public class TurnoRepararHabilitado implements TurnoReparar{
	
	@Override
	public boolean repararEdificio(Edificio edificio, Aldeano aldeano) {
		aldeano.finalizarAcciones();
		return edificio.reparar();
	}
}
