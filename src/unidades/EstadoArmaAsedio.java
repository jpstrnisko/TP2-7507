package unidades;

import edificios.Edificio;

public interface EstadoArmaAsedio {

	boolean estaMontada();

	void atacar(Edificio edificio);

}
