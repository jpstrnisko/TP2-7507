package unidades;

import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;

public class ArmaDeAsedio extends Unidad{
	EstadoArmaDeAsedio estado;
	
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

	public void atacar(Atacable objetivo) {
		estado.atacar(objetivo);
	}
}
