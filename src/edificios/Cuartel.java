package edificios;


import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Edificio {

	private static final int VELOCIDADREPARACION = 50;
	private static final int VIDAINICIAL = 250;
		
	public Cuartel() {
		this.costo = 50;
		this.tamanio = 4;
		this.vida = new VidaEdificio(VIDAINICIAL, VELOCIDADREPARACION, this);
	}
	
	public Espadachin crearUnEspadachin() {
		return new Espadachin();
	}
	
	public Arquero crearUnArquero() {
		return new Arquero();
	}

	public void comenzarProduccionEspadachin() {
		this.estadoEdificio.producir(new Espadachin(), this);
	}

	public void comenzarProduccionArquero() {
		this.estadoEdificio.producir(new Arquero(), this);
	}

}

