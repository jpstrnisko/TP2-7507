package edificios;

import interfaces.EstadoEdficio;
import unidades.Aldeano;

public class EdificioConstruido implements EstadoEdficio {

	@Override
	public boolean estaEnConstruccion() {
		return false;
	}

	@Override
	public void continuarDesarrollo(Edificio edificio, Aldeano aldeano) {
	}


}
