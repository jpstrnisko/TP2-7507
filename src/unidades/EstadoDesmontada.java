package unidades;

import edificios.Edificio;

public class EstadoDesmontada implements EstadoArmaAsedio {

	@Override
	public boolean estaMontada() {
		return false;
	}

	@Override
	public void atacar(Edificio edificio) {
		
	}

}
