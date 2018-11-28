package acciones;

import areaJuego.Posicion;
import edificios.Edificio;
import edificios.FabricaEdificios;
import edificios.PlazaCentral;
import interfaces.Accion;
import interfaces.Atacable;
import interfaces.IAtacante;
import unidades.Aldeano;
import unidades.Unidad;

public class Atacar implements Accion {
	
	private Atacable objetivo;
	private IAtacante atacante;

	public Atacar(Atacable objetivo, IAtacante atacante) {
		this.objetivo = objetivo;
		this.atacante = atacante;
	}

	@Override
	public void hacer() {
		this.atacante.atacar(this.objetivo);
	}


}
