package turnos;

import edificios.Edificio;
import interfaces.TurnoReparar;
import unidades.Aldeano;

public class TurnoRepararFinalizado implements TurnoReparar{

	@Override
	public boolean repararEdificio(Edificio edificio, Aldeano aldeano) {
		return false;
	}
	


}
