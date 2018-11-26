package edificios;


import areaJuego.Posicion;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Edificio {

	private static final int VELOCIDADREPARACION = 50;
	private static final int VIDAINICIAL = 250;
		
	public Cuartel() {
		this.costo = 50;
		this.tamanio = 4;
		this.vida = new VidaEdificio(VIDAINICIAL, VELOCIDADREPARACION);
	}
	
	public Espadachin crearUnEspadachin() {
		return new Espadachin();
	}
	
	public Arquero crearUnArquero() {
		return new Arquero();
	}
	
}

