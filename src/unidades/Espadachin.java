package unidades;

import areaJuego.Posicion;
import interfaces.Atacable;

public class Espadachin extends Unidad {
	
	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.distanciaMaximaAtaque = 1; //cuerpo a cuerpo
	}

	@Override
	public void atacar(Atacable atacable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean moverA(Posicion posicion) {
		// TODO Auto-generated method stub
		return false;
	}

}
