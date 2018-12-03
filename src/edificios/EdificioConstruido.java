package edificios;

import interfaces.EstadoEdficio;
import unidades.Aldeano;
import unidades.Unidad;

public class EdificioConstruido implements EstadoEdficio {

	@Override
	public boolean estaEnConstruccion() {
		return false;
	}

	@Override
	public void continuarDesarrollo(Edificio edificio, Aldeano aldeano) {
	}

	@Override
	public boolean esReparable() {
		return true;
	}

	@Override
	public void producir(Unidad unidadAProducir, Edificio edificio) {
		edificio.productorUnidades.producir(unidadAProducir, edificio);
	}

}
