package interfaces;

import edificios.Edificio;
import unidades.Unidad;

public interface EstadoArmaDeAsedio {

	boolean estaMontada();

	void atacar(Edificio edificio);

	void atacar(Unidad unidad);

	void seleccionarObjetivo(Atacable objetivo);
}
