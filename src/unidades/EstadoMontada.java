package unidades;

import edificios.Edificio;

public class EstadoMontada implements EstadoArmaAsedio {
	protected int danioAEdificios = 75;

	@Override
	public boolean estaMontada() {
		return true;
	}

	@Override
	public void atacar(Edificio edificio) {
		edificio.quitarVida(danioAEdificios);
	}
}
