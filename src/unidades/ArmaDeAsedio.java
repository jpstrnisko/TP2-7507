package unidades;

import interfaces.Atacable;

public class ArmaDeAsedio extends Unidad{
	Boolean montada;
	
	public ArmaDeAsedio() {
		this.vida = 150;
		this.costo = 200;
		this.distanciaMaximaAtaque = 5;
		this.montada = false;
	}

	public boolean estaMontada() {
		return montada;
	}

	public void montar() {
		montada = true;
	}

	public void desmontar() {
		montada = false;
	}

	public void atacar(Atacable objetivo) {
		if(montada) {
			objetivo.esAtacadoPor(this);
		}
	}
}
