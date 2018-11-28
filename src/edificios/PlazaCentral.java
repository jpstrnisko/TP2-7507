package edificios;

import turnos.Jugador;
import unidades.Aldeano;

public class PlazaCentral extends Edificio {

	private static final int VELOCIDADREPARACION = 25;
	private static final int VIDAINICIAL = 450;
	private final int TURNOSPARACONSTRUCCION = 3;

	
	public PlazaCentral() {
		this.costo = 100;
		this.tamanio = 4;
		this.vida = new VidaEdificio(VIDAINICIAL, VELOCIDADREPARACION, this);
		

	}
	public Aldeano crearUnAldeano() {
		return new Aldeano();
	}
	@Override
	public void continuarConstruccion() {
		this.turnoConstruccion++;
		if(this.turnoConstruccion > this.TURNOSPARACONSTRUCCION) {
			this.terminarConstruccion();
		}
		
	}
}