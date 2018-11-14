package edificios;

import unidades.Aldeano;

public class PlazaCentral extends Edificio {
	
	public PlazaCentral() {
		this.costo = 100;
		this.tamanio = 4;
		int velocidadReparacion = 25;
		int vidaInicial = 450;
		this.vida = new VidaEdificio(vidaInicial, velocidadReparacion);

	}
	public Aldeano crearUnAldeano() {
		return new Aldeano();
	}
}