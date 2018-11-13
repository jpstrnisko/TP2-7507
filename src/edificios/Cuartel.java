package edificios;

import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Edificio {
	
	public Cuartel() {
		this.vida = 250;
		this.costo = 50;
		this.velocidadReparacion = 50;
	}
	
	public Espadachin crearUnEspadachin() {
		return new Espadachin();
	}
	
	public Arquero crearUnArquero() {
		return new Arquero();
	}

}
