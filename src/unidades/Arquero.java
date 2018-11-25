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
	public void atacar(Atacable atacable) {
		atacable.esAtacadoPor(this);
	}
	
	@Override
	public boolean moverA(Posicion posicion) {
		return false;
	}

}
