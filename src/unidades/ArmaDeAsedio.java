package unidades;

import areaJuego.Posicion;
import interfaces.Atacable;

public class ArmaDeAsedio extends Unidad{
	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
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
