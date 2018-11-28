package interfaces;

import edificios.Edificio;
import unidades.Aldeano;

public interface EstadoEdficio {

	boolean estaEnConstruccion();

	void continuarDesarrollo(Edificio edificio, Aldeano aldeano);

}
