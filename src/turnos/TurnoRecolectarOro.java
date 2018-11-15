package turnos;

import interfaces.TurnoRecolectar;
import unidades.Aldeano;

public class TurnoRecolectarOro implements TurnoRecolectar{

	
	public Number recolectarOro(Aldeano aldeano) {
		aldeano.finalizarTurnoRecoleccion();
		return 20;
	}
}
