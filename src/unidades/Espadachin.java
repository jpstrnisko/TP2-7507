package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;


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
