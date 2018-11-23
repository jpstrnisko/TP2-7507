package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.IAtacante;


public class Arquero extends Unidad implements IAtacante {
	
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
}
