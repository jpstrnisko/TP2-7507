package edificios;

import unidades.ArmaDeAsedio;
import unidades.Unidad;

public class Castillo extends Edificio {
	
	private static final int VELOCIDADREPARACION = 15;
	private static final int VIDAINICIAL = 1000;
	private static final int DANIOGENERADO = 20; //Tanto a unidades como a otros edificios.
	
	public Castillo() {
		this.costo = -1; //no se puede construir
		this.tamanio = 8;
		this.vida = new VidaEdificio(VIDAINICIAL, VELOCIDADREPARACION);
	}
	
	public ArmaDeAsedio crearUnArmaDeAsedio() {
		return new ArmaDeAsedio();
	}
	
	public void atacar(Edificio edificio) {
		edificio.quitarVida(DANIOGENERADO);
	}
	
	public void atacar(Unidad unidad) {
		unidad.quitarVida(DANIOGENERADO);
	}

}

