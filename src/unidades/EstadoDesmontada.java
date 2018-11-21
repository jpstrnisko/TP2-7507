package unidades;

import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;

public class EstadoDesmontada implements EstadoArmaDeAsedio {

	ArmaDeAsedio armaDeAsedio;

	public EstadoDesmontada(ArmaDeAsedio armaDeAsedio_) {
		this.armaDeAsedio = armaDeAsedio_;
	}

	@Override
	public boolean estaMontada() {
		return false;
	}

	@Override
	public void atacar(Atacable objetivo) {
	}

}
