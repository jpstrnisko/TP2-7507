package unidades;
import edificios.Edificio;

import java.util.List;

import acciones.Atacar;
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


	@Override
	protected void reiniciarAccion() {
		this.accion = new Inactivo();
	}

	@Override
	public void seleccionarObjetivo(Atacable objetivo) {
		accion = Atacar.obtenerInstanciaAccion(objetivo, this, distanciaMaximaAtaque);
	}


	@Override
	public int obtenerRangoAtaque() {
		return distanciaMaximaAtaque;
	}
	
	
}
