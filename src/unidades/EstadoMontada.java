package unidades;

import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;

public class EstadoMontada implements EstadoArmaDeAsedio {
	
	ArmaDeAsedio armaDeAsedio;

	public EstadoMontada(ArmaDeAsedio armaDeAsedio_) {
		this.armaDeAsedio = armaDeAsedio_;
	}

	@Override
	public boolean estaMontada() {
		return true;
	}

	@Override
	public void atacar(Atacable objetivo) {
		objetivo.esAtacadoPor(armaDeAsedio);
	}

}
