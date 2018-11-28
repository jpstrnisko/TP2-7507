package edificios;

import interfaces.EstadoEdficio;
import unidades.Aldeano;

public class EdificioEnReparacion implements EstadoEdficio {

	@Override
	public boolean estaEnConstruccion() {
		return false;
	}

	@Override
	public void continuarDesarrollo(Edificio edificio, Aldeano aldeano) {
		edificio.reparar();
		
		if (edificio.poseeVidaMaxima())
			aldeano.recolectarOro();
	}

}
