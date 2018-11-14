package edificios;

import unidades.ArmaDeAsedio;

public class Castillo extends Edificio {
	
	public Castillo() {
		this.costo = -1; //no se puede construir
		this.tamanio = 8;
		int velocidadReparacion = 15;
		int vidaInicial = 1000;
		this.vida = new VidaEdificio(vidaInicial, velocidadReparacion);
	}
	
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}

}

