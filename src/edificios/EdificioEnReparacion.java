package edificios;

import interfaces.EstadoEdficio;
import unidades.Aldeano;
import unidades.Unidad;

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

	@Override
	public boolean esReparable() {
		return false;
	}

	@Override
	public void producir(Unidad unidadAProducir, Edificio edificio) {
		edificio.productorUnidades.producir(unidadAProducir, edificio);
	}

}
