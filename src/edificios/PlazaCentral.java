package edificios;

import unidades.Aldeano;

public class PlazaCentral extends Edificio {
	
	public PlazaCentral() {
		this.vida = 450;
		this.costo = 100;
		this.velocidadReparacion = 25;
		this.tamanio = 4;

	}
	public Aldeano crearUnAldeano() {
		return new Aldeano();
	}
}