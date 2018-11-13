package edificios;

import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel {
	public Espadachin crearUnEspadachin() {
		return new Espadachin();
	}
	
	public Arquero crearUnArquero() {
		return new Arquero();
	}

	public Object obtenerVida() {
		return 250;
	}
}
