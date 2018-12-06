package unidades;

import edificios.Edificio;
import interfaces.Atacable;
import interfaces.EstadoArmaDeAsedio;

public class EstadoDesmontada implements EstadoArmaDeAsedio {

	protected int danioAEdificios = 0;
	protected int danioAUnidades = 0;
	protected int distanciaMaximaAtaque = 0;
	protected ArmaDeAsedio armaDeAsedio;
	protected UnidadAtacante atacante;

	public EstadoDesmontada(ArmaDeAsedio armaDeAsedio_) {
		this.armaDeAsedio = armaDeAsedio_;
	}

	@Override
	public boolean estaMontada() {
		return false;
	}

	@Override
	public void atacar(Edificio edificio) {
		
	}

	@Override
	public void atacar(Unidad unidad) {
		
	}

	@Override
	public void seleccionarObjetivo(Atacable objetivo) {
		
	}
}
