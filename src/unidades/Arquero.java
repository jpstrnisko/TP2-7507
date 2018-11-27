package unidades;
import edificios.Edificio;

import java.util.List;

import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.IAtacante;


public class Arquero extends Unidad implements IAtacante {
	
	protected int danioAEdificios = 10;
	protected int danioAUnidades = 15;
	protected UnidadAtacante atacante;
	
	public Arquero() {
		this.vida = new VidaUnidad(75, this);
		this.costo = 75;
		this.distanciaMaximaAtaque = 3;
		this.atacante = new UnidadAtacante(this, danioAEdificios, danioAUnidades, distanciaMaximaAtaque);
	}

	
	@Override
	public void atacar(Edificio edificio) {
		this.atacante.atacar(edificio);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		this.atacante.atacar(unidad);
	}
	
	
}
