package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;
import interfaces.IAtacante;


public class ArmaDeAsedio extends Unidad implements IAtacante {
	
	protected EstadoArmaDeAsedio estado;
	
	public ArmaDeAsedio() {
		this.vida = new VidaUnidad(150, this);
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
		this.estado = new EstadoDesmontada(this);
	}
	
	public boolean estaMontada() {
		return estado.estaMontada();
	}

	public void montar() {
		this.estado = new EstadoMontada(this);
	}

	public void desmontar() {
		this.estado = new EstadoDesmontada(this);
	}

	@Override
	public void atacar(Edificio edificio) {
		this.estado.atacar(edificio);
	}
	
	@Override
	public void atacar(Unidad unidad) {
		this.estado.atacar(unidad);
	}
}
