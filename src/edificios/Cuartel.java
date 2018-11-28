package edificios;


import areaJuego.Posicion;
import unidades.ArmaDeAsedio;
import unidades.Arquero;
import unidades.Espadachin;

public class Cuartel extends Edificio {

	private static final int VELOCIDADREPARACION = 50;
	private static final int VIDAINICIAL = 250;
	private final int TURNOSPARACONSTRUCCION = 3;

		
	public Cuartel() {
		this.costo = 50;
		this.tamanio = 4;
		this.turnoConstruccion = 1;
		this.enConstruccion = true;
		this.vida = new VidaEdificio(VIDAINICIAL, VELOCIDADREPARACION, this);
	}
	
	public Espadachin crearUnEspadachin() {
		return new Espadachin();
	}
	
	public Arquero crearUnArquero() {
		return new Arquero();
	}

	@Override
	public void continuarConstruccion() {
		this.turnoConstruccion++;
		if(this.turnoConstruccion > this.TURNOSPARACONSTRUCCION) {
			this.terminarConstruccion();
		}		
	}
	

	
}

