package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;


import interfaces.Atacable;

public class Espadachin extends Unidad {
	
	protected int danioAUnidades = 25;
	protected int danioAEdifcios = 15;
	
	public Espadachin() {
		this.vida = 100;
		this.costo = 50;
		this.distanciaMaximaAtaque = 1; //cuerpo a cuerpo
	}
	
	public void atacar(Atacable objetivo) {
		objetivo.esAtacadoPor(this);
	}

}
