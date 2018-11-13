package edificios;

import unidades.ArmaDeAsedio;

public class Castillo extends Edificio {
	
	public Castillo() {
		this.vida = 1000;
		this.costo = -1; //no se puede construir
		this.velocidadReparacion = 15;
		this.tamanio = 8;
	}
	
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}

}

