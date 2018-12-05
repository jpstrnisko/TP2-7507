package edificios;

import unidades.Aldeano;

public class PlazaCentral extends Edificio {

	private static final int VELOCIDADREPARACION = 25;
	private static final int VIDAINICIAL = 450;

	public PlazaCentral() {
		this.costo = 100;
		this.tamanio = 4;
		this.vida = new VidaEdificio(VIDAINICIAL, VELOCIDADREPARACION, this);
		
	}
	public Aldeano crearUnAldeano() {
		return new Aldeano();
	}
	
	public void comenzarProduccionAldeano() {
		this.estadoEdificio.producir(new Aldeano(), this);
	}
}