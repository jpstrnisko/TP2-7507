package unidades;

import interfaces.Atacable;

public class Espadachin extends Unidad {
	
	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.distanciaMaximaAtaque = 1; //cuerpo a cuerpo
	}
	
	public void atacar(Atacable objetivo) {
		objetivo.esAtacadoPor(this);
	}

}
