package edificios;

import unidades.Arquero;
import unidades.Espadachin;
import unidades.Unidad;

public class Cuartel extends Edificio {
	
	public Cuartel() {
		this.costo = 50;
		this.tamanio = 4;
		int velocidadReparacion = 50;
		int vidaInicial = 250;
		this.vida = new VidaEdificio(vidaInicial, velocidadReparacion);
	}
	
	public Espadachin crearUnEspadachin() {
		return new Espadachin();
	}
	
	public Arquero crearUnArquero() {
		return new Arquero();
	}

	@Override
	public void atacar(Edificio edificio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Unidad unidad) {
		// TODO Auto-generated method stub
		
	}

}

