package unidades;

import edificios.Edificio;
import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;

public class EstadoMontada implements EstadoArmaDeAsedio {
	
	protected int danioAEdificios = 75;
	protected int danioAUnidades = 0;
	protected int distanciaMaximaAtaque = 5;
	protected ArmaDeAsedio armaDeAsedio;
	protected UnidadAtacante atacante;

	public EstadoMontada(ArmaDeAsedio armaDeAsedio) {
		this.armaDeAsedio = armaDeAsedio;
		this.atacante = new UnidadAtacante(armaDeAsedio, danioAEdificios, danioAUnidades, distanciaMaximaAtaque);
	}

	@Override
	public boolean estaMontada() {
		return true;
	}

	@Override
	public void atacar(Edificio edificio) {
		atacante.atacar(edificio);
	}

	@Override
	public void atacar(Unidad unidad) {
		atacante.atacar(unidad);
	}
}
