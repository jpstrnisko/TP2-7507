package interfaces;

import areaJuego.Posicion;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public interface Atacable {

	void esAtacadoPor(ArmaDeAsedio armaDeAsedio);

	void esAtacadoPor(Espadachin espadachin);

	void esAtacadoPor(Arquero arquero);
	
}
