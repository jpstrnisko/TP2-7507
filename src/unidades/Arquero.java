package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;


public class Arquero extends Unidad {
	
	protected int danioAEdificios = 10;
	protected int danioAUnidades = 15;
	
	public Arquero() {
		this.vida = 75;
		this.costo = 75;
		this.distanciaMaximaAtaque = 3;
	}

	
	@Override
	public void atacar(Edificio edificio) {
		edificio.quitarVida(this.danioAEdificios);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		unidad.quitarVida(this.danioAUnidades);
	}

	@Override
	public boolean moverA(Posicion posicion) {
		// TODO Auto-generated method stub
		return false;
	}

}
