package interfaces;

import edificios.Edificio;
import unidades.Aldeano;
import unidades.Unidad;

public interface EstadoEdficio {

	boolean estaEnConstruccion();

	void continuarDesarrollo(Edificio edificio, Aldeano aldeano);

	boolean esReparable();

	void producir(Unidad unidadAProducir, Edificio edificio);

}
