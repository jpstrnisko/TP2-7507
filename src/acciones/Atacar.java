package acciones;

import edificios.Edificio;
import interfaces.Accion;
import interfaces.Atacable;
import interfaces.IAtacante;
import unidades.Inactivo;
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
		/*Se puede cambiar por double dispatch*/
		if(Edificio.class.isAssignableFrom(objetivo.getClass()))
			this.atacante.atacar((Edificio) this.objetivo);
		else
			this.atacante.atacar((Unidad) this.objetivo);
	}

	public static Accion obtenerInstanciaAccion(Atacable objetivo, IAtacante atacante, int rangoDeAtaque) {
		if(objetivo.estaEnRangoDe(rangoDeAtaque, atacante) && objetivo.obtenerJugador() != atacante.obtenerJugador()) 
			return new Atacar(objetivo, atacante);
		
		return new Inactivo();
	}


}
