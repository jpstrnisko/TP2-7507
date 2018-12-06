package edificios;

import interfaces.ProductorUnidades;
import unidades.Unidad;

public class ProduccionPausada implements ProductorUnidades {

	@Override
	public void producir(Unidad unidad, Edificio productor) {
		return;
	}

	@Override
	public void avanzar() {
		
	}

}
