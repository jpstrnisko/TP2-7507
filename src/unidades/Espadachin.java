package unidades;

import edificios.Edificio;

public class Espadachin extends Unidad {
	
	protected int danioAUnidades = 25;
	protected int danioAEdifcios = 15;
	
	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.distanciaMaximaAtaque = 1; //cuerpo a cuerpo
	}
	
	@Override
	public void atacar(Edificio edificio) {
		edificio.quitarVida(this.danioAEdifcios);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		unidad.quitarVida(this.danioAUnidades);
	}

}
