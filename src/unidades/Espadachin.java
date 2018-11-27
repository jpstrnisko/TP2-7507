package unidades;
import edificios.Edificio;

import java.util.List;

import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.IAtacante;


public class Espadachin extends Unidad implements IAtacante {
	
	protected int danioAUnidades = 25;
	protected int danioAEdificios = 15;
	protected UnidadAtacante atacante;
	
	public Espadachin() {
		this.vida = new VidaUnidad(100, this);
		this.costo = 50;
		this.distanciaMaximaAtaque = 1; //cuerpo a cuerpo
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
