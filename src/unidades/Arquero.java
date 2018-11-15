package unidades;

import areaJuego.Posicion;
import interfaces.Atacable;

public class Arquero extends Unidad {
	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.distanciaMaximaAtaque = 3;
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
