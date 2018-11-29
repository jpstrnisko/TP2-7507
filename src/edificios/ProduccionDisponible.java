package edificios;

import interfaces.ProductorUnidades;
import unidades.Unidad;

public class ProduccionDisponible implements ProductorUnidades {

	@Override
	public void producir(Unidad unidad, Edificio productor) {
		if (productor.obtenerJugador().quitarOro(unidad.obtenerCosto()))
			productor.productorUnidades = new ProduccionOcupada(unidad, productor);
	}

	@Override
	public void avanzar() {
		
	}

}
