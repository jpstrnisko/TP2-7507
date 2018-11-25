package unidades;
import edificios.Edificio;
import areaJuego.Posicion;
import interfaces.Atacable;


import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;

public class ArmaDeAsedio extends Unidad{
	
	protected EstadoArmaAsedio estado;
	
	public ArmaDeAsedio() {
		this.vida = 150;
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
	public boolean moverA(Posicion posicion) {
		// TODO Auto-generated method stub
		return false;
	}

	public void atacar(Atacable objetivo) {
		estado.atacar(objetivo);
	}
}
